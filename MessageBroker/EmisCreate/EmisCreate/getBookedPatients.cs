using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using IBM.Broker.Plugin;

namespace EmisCreate
{
    /// <summary>
    /// LogonNode Class
    /// </summary>
    public class getBookedPatients : NBComputeNode
    {
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

                #region UserCode

                
                EM_PACC.PatientAccess emis = new EM_PACC.PatientAccess();

                object booked, error, outcome;
                int within, beforetime;
                string sessionID, username, password, loginID;
                sessionID = (string) inxmlRoot["EMIS"]["sessionID"];
                username = (string)inxmlRoot["EMIS"]["username"];
                password = (string)inxmlRoot["EMIS"]["password"];
                loginID = (string)inxmlRoot["EMIS"]["loginID"];

                within = (int)inxmlRoot["EMIS"]["within"];
                beforetime = (int)inxmlRoot["EMIS"]["before"];
                NBElement blob = outputRoot[NBParsers.XMLNSC.ParserName];
                emis.GetBookedPatients(sessionID, within, beforetime, out booked, out error, out outcome);
                string requesttype = "getBookedPatients";
                if ((int)outcome == 1)
                {
                    blob["EMIS"].CreateLastChild(null, "patients", (string)booked);
                    outTerminal.Propagate(outAssembly);
                }
                else
                {
                    blob["EMIS"].CreateLastChild(null, "requesttype", requesttype);
                    blob["EMIS"].CreateLastChild(null, "error", error);
                    blob["EMIS"].CreateLastChild(null, "outcome", outcome);
                    failureTerminal.Propagate(outAssembly);
                }
                #endregion UserCode
            }
        }
    }
}