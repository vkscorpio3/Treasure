package com.soap;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class SOAPClientSAAJ {

    /**
     * Starting point for the SAAJ - SOAP Client Testing
     */
    public static void main(String args[]) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();


            //no ?wsdl
            String url = "http://192.168.1.19:8080/EasyMedAPI/ws/hugs";            
            //SOAPMessage soapget= soapConnection.get("http://192.168.1.19:8080/EasyMedAPI/ws/hugs?wsdl");
            //printSOAPResponse(soapget);
            
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);            
            // Process the SOAP Response
            printSOAPResponse(soapResponse);

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://labresult.ws.api.easymed.com/";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("lab", serverURI);
        
        /*
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:lab="http://labresult.ws.api.easymed.com/">
        <soapenv:Header/>
        <soapenv:Body>
           <lab:labResult>
              <!--Optional:-->
              <arg0>test</arg0>
              <arg1>true</arg1>
           </lab:labResult>
        </soapenv:Body>
     </soapenv:Envelope>
*/
        // SOAP Body  
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("labResult","lab");
        
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg0");
        soapBodyElem1.addTextNode("mutantninja@gmail.com");
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("arg1");
        soapBodyElem2.addTextNode("true");

        //MimeHeaders headers = soapMessage.getMimeHeaders();
        //headers.addHeader("SOAPAction", serverURI  + "labResult");

        MimeHeaders headers = soapMessage.getMimeHeaders();
       headers.addHeader("SOAPAction", "");

       // soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = \n");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

    /**
     * Method used to print the SOAP Response
     */
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }

}