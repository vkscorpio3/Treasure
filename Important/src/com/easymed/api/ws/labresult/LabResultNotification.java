package com.easymed.api.ws.labresult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
@WebService
public interface LabResultNotification {
	
	
	public boolean labResult( String hl7message, boolean outcome) ;
		

	
}
