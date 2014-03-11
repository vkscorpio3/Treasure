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

            String urls = "https://secure.easymedmobile.com/notifications/lab/hugs";
            
            //no ?wsdl
            String url = "http://192.168.1.19:8080/EasyMedAPI/ws/hugs";            
            SOAPMessage soapget= soapConnection.get(urls+"?wsdl");
            printSOAPResponse(soapget);
            
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), urls);      
            
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
        
        String hl7message="MSH|^~\\&|unilab2|32^MATPED-LB|EasyMed||20130619162139.139+0200||ORU^R01|ul2.32.3.133764.1371651699139|F|2.5||1371651699139|||CHE|8859/15|fr\n" +
        		"PID|1||6||XXXX||||||||0041765093523|||||||||||||||||\n" +
        		"OBR|1|4^^20130502^3001|46593|EXAM||20130502000000+0200|20130502100000+0200||0^0|||||201305021114+0200|1556^sgv^sang veineux^4||00447952414020^WPN^PH~0041783720000^BPN^CP~cardiologie@hcuge.ch^NET^Internet|N|N|||20130502111420+0200|||F||1^R\n" +
        		"OBX|2|TX|329647^INR^29570^63496|0|NON INTERPRÉT.||||||F|||20130619162124+0200|2164^INR^20^11707^Hémostase^^Hémostase|MKF^MKF";
        
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