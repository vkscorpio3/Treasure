package com.soap;

import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.easymed.api.ws.labresult.LabResultNotification;

public class webserviceClient  {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8080/Important/ws/hugs?wsdl");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://labresult.ws.api.easymed.com/","StockQuoteReporter");
		QName qnamePort =null;
		Service service = Service.create(url, qname);

		 System.out.println(service.getServiceName());
		 
		 Iterator<QName> iut=service.getPorts();
		 while (iut.hasNext()){
			 qnamePort=iut.next();
			 System.out.println(qnamePort);
		 }
		 
		 
		 LabResultNotification hello = service.getPort(LabResultNotification.class);
		 System.out.println(service.getWSDLDocumentLocation());
		 System.out.println(service);
		 //LabResultNotification hello = service.getPort(qnamePort,LabResultNotification.class);

		System.out.println(hello.labResult("exp", true));

	}
}
