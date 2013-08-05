package com.easymed.api.ws.labresult;


import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Use;


@WebService(name="hugsname" , portName="StockQuotePort",
serviceName="StockQuoteReporter")
public class LabResultNotificationImpl implements LabResultNotification{
	
	@Override
	public boolean labResult( @WebParam (name="hl7")String hl7message,@WebParam (name="outcome") boolean outcome) throws Exception {
		
		System.out.println(hl7message);
		System.out.println(outcome);
		
		if(hl7message !=null && hl7message.equals("exp")){
			throw new SomeException("experction thrown by purpose by ganesan !!!");
		}
		return outcome;
	}

}
