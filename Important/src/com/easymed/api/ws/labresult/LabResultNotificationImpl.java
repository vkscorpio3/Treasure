package com.easymed.api.ws.labresult;


import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;


@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class LabResultNotificationImpl implements LabResultNotification{
	
	@Override
	public boolean labResult( String hl7message, boolean outcome) {
		
		System.out.println(hl7message);
		System.out.println(outcome);
		return outcome;
	}

}
