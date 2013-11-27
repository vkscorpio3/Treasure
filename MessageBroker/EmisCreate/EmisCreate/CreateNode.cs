using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using IBM.Broker.Plugin;

namespace EmisCreate
{
    /// <summary>
    /// CreateNode Class
    /// </summary>
    public class CreateNode : NBComputeNode
    {

        public EM_PACC.PatientAccess emis = new EM_PACC.PatientAccess();

        /// <summary>
        /// Evaluate Method
        /// </summary>
        /// <param name="inputAssembly"></param>
        public override void Evaluate(NBMessageAssembly inputAssembly)
        {
            NBOutputTerminal outTerminal = OutputTerminal("Out");
            NBOutputTerminal failureTerminal = OutputTerminal("Failure");

            NBMessage inputMessage = inputAssembly.Message;

            // Create a new empty message, ensuring it is disposed after use
            using (NBMessage outputMessage = new NBMessage(inputMessage))
            {
                NBMessageAssembly outAssembly = new NBMessageAssembly(inputAssembly, outputMessage);
                NBElement inputRoot = inputMessage.RootElement;
                NBElement outputRoot = outputMessage.RootElement;

                NBElement inxmlRoot = inputRoot[NBParsers.XMLNSC.ParserName];
                IEnumerable<NBElement> invoices = inxmlRoot["EMIS"];
                // Optionally copy message headers, remove if not needed
                //CopyMessageHeaders(inputRoot, outputRoot);

                #region UserCode

                NBElement blob = outputRoot[NBParsers.XMLNSC.ParserName];
                string address, uci, volumeGroup, databaseName, SupplierID, username, password,requesttype;
                object CDB, productName, version, loginID, error, outcome, sessionID, booked;
                int within, beforetime;
                int appType = (int) inxmlRoot["EMIS"]["applicationtype"];
                address = (string) inxmlRoot["EMIS"]["address"];
                uci = (string) inxmlRoot["EMIS"]["uci"];
                volumeGroup = (string) inxmlRoot["EMIS"]["volumegroup"];
                databaseName = (string) inxmlRoot["EMIS"]["databasename"];
                SupplierID = (string) inxmlRoot["EMIS"]["supplierid"];
                username = (string)inxmlRoot["EMIS"]["username"];
                password = (string)inxmlRoot["EMIS"]["password"];

                requesttype = "InitializeWithID";
                this.emis.InitializeWithID(appType, address, uci, volumeGroup,databaseName, SupplierID, out CDB, out productName, out version, out loginID, out error, out outcome, out sessionID);
                if ((int)outcome == 1)
                {
                    requesttype = "Logon";
                    this.emis.Logon((string)loginID, username, password, out sessionID, out error, out outcome);
                    blob["EMIS"].CreateLastChild(null, "loginID", loginID);
                    if ((int)outcome == 1)
                    {
                        blob["EMIS"].CreateLastChild(null, "sessionID", sessionID);
                        within = (int)inxmlRoot["EMIS"]["within"];
                        beforetime = (int)inxmlRoot["EMIS"]["before"];
                        requesttype = "GetBookedPatients";
                        this.emis.GetBookedPatients((string)sessionID, within, beforetime, out booked, out error, out outcome);
                        if ((int)outcome == 1)
                        {
                            this.getResults(blob,booked);
                            outTerminal.Propagate(outAssembly);
                        }
                    }
                }
                if ((int) outcome != 1)
                {
                    this.ThrowFailure(blob,error,outcome,requesttype);
                    failureTerminal.Propagate(outAssembly);
                }
                #endregion UserCode
            }
        }

        private void ThrowFailure(NBElement blob, object error, object outcome, object requesttype)
        {
            blob["EMIS"].DeleteAllChildren();
            blob["EMIS"].CreateLastChild(null, "requesttype", requesttype);
            blob["EMIS"].CreateLastChild(null, "error", error);
            blob["EMIS"].CreateLastChild(null, "outcome", outcome);
        }

        private void getResults(NBElement blob, object booked)
        {
            blob["EMIS"].DeleteAllChildren();
            blob["EMIS"].CreateLastChild(null, "patients", booked);
        }       
       
        #region CopyMessageHeaders
        /// <summary>
        /// CopyMessageHeaders Method
        /// </summary>
        /// <param name="inputRoot"></param>
        /// <param name="outputRoot"></param>
        private static void CopyMessageHeaders(NBElement inputRoot, NBElement outputRoot)
        {
            // Iterate though the headers under the root element
            foreach (NBElement currentElement in inputRoot)
            {
                // Stop before the lastchild which is the body of the message
                if (currentElement.NextSibling != null)
                {
                    // Copy the header and add it to the output message
                    outputRoot.AddLastChild(currentElement);
                }
            }
        }
        #endregion

    }
}