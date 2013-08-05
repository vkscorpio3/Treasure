package com.easymed.api.ws.labresult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Use;
@WebService(name="hugss")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT ,use=Use.LITERAL,parameterStyle=ParameterStyle.BARE)
public interface LabResultNotification {
	
	@WebMethod(action = "urn:process")
	public boolean labResult( @WebParam (name="hl7")String hl7message,@WebParam (name="outcome") boolean outcome) throws Exception ;

		

	
}




/**

Document literal Bare


<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:lab="http://labresult.ws.api.easymed.com/">
<soapenv:Header/>
<soapenv:Body>
   <lab:hl7>?</lab:hl7>
   <lab:outcome>?</lab:outcome>
</soapenv:Body>
</soapenv:Envelope>
**/




/**

Document literal wrappered

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:lab="http://labresult.ws.api.easymed.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <lab:labResult>
         <hl7>fff</hl7>
         <outcome>true</outcome>
      </lab:labResult>
   </soapenv:Body>
</soapenv:Envelope>
**/