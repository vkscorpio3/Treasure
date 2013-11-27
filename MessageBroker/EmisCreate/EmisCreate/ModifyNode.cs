using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using IBM.Broker.Plugin;

namespace EmisCreate
{
    /// <summary>
    /// ModifyNode Class
    /// </summary>
    public class ModifyNode : NBComputeNode
    {
        /// <summary>
        /// Evaluate Method
        /// </summary>
        /// <param name="inputAssembly"></param>
        public override void Evaluate(NBMessageAssembly inputAssembly)
        {
            NBOutputTerminal outTerminal = OutputTerminal("Out");

            NBMessage inputMessage = inputAssembly.Message;

            // Create a new message from a copy of the 
            // inboundMessage, ensuring it is disposed of after use
            using (NBMessage outputMessage = new NBMessage(inputMessage))
            {
                NBMessageAssembly outAssembly = new NBMessageAssembly(inputAssembly, outputMessage);
                NBElement inputRoot = inputMessage.RootElement;
                NBElement outputRoot = outputMessage.RootElement;

                #region UserCode
                NBElement xmlRoot = outputRoot[NBParsers.XMLNSC.ParserName];
                NBElement xmlDecl = xmlRoot[NBParsers.XMLNSC.XmlDeclaration, "XmlDeclaration"];
                if (xmlDecl == null)
                {
                    // Create an XML Declaration if required
                    NBParsers.XMLNSC.CreateXmlDeclaration(xmlRoot, "1.0", "UTF-8", "yes");
                }
                string notarget = "";
                string ns = "http://www.example.org/store";
                NBElement storeDetails = xmlRoot[notarget, "LoyaltyProgram"][ns, "StoreDetails"];
                string storeName = "";
                string storeStreet = "";
                string storeTown = "Happyville";
                switch ((string)storeDetails[ns, "StoreID"])
                {
                    case "001":
                        storeName = "Broker Brothers Central";
                        storeStreet = "Exuberant Avenue";
                        break;
                    case "002":
                        storeName = "Broker Brothers Mall";
                        storeStreet = "Enthusiastic Crescent";
                        break;
                    case "003":
                        storeName = "Broker Brothers District";
                        storeStreet = "Peaceful Road";
                        break;
                }
                storeDetails.CreateLastChild(ns, "StoreName", storeName);
                storeDetails.CreateLastChild(ns, "StoreStreet", storeStreet);
                storeDetails.CreateLastChild(ns, "StoreTown", storeTown);
                #endregion UserCode

                // Change the following if not propagating message to the 'Out' terminal
                outTerminal.Propagate(outAssembly);
            }
        }
    }
}
