package com.ibm.broker.email.samples;
import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.*;
/**
 * @author leed
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/*
Sample program for use with IBM WebSphere Message Broker
© Copyright International Business Machines Corporation 2007, 2010 
Licensed Materials - Property of IBM
*/
public class EmailFailedResponse extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");

		MbMessage inMessage = inAssembly.getMessage();

		// create new message
		MbMessage outMessage = new MbMessage(inMessage);
		MbMessageAssembly outAssembly = new MbMessageAssembly(inAssembly,
				outMessage);

		// ----------------------------------------------------------
		// Add user code below
		
		// Set the content type to be html so that it may be viewed by a browser
		MbElement outRoot = outMessage.getRootElement();
		MbElement outProperties = outRoot.getFirstElementByPath("Properties");	
		MbElement contentType = outProperties.getFirstElementByPath("ContentType");			
		contentType.setValue("text/html");	
			
		// Clear out any messages 
		outRoot.getLastChild().detach();

		// Get the exception reported
		MbElement exception = inAssembly.getExceptionList().getRootElement().getFirstElementByPath("RecoverableException");
		
		// Create a HTML response
		StringBuffer buffer = new StringBuffer();			
		String head = "<HTML><BODY TEXT=\"#ff0000\"><form action=\"http://localhost:7080/hello\" method=post>";			
		buffer.append(head);
			
		// Iterate through the exception stacktrace and add the reason text to the message response
		String text;
		while (exception != null) {
			text = (String)exception.getFirstElementByPath("Text").getValue();
			if (text.length() > 0) {
				buffer.append(text);
				buffer.append("<br>");					
			}
			exception = exception.getFirstElementByPath("RecoverableException");
		}
		
		// Complete the HTML body
		String tail = "<br><input type=\"submit\" name=\"OK\" value=\"OK\"></form></BODY></HTML>";
		
		buffer.append(tail);
		// Create the Broker Blob Parser element
		MbElement outParser = outRoot.createElementAsLastChild(MbBLOB.PARSER_NAME);
		// Create the BLOB element in the Blob parser domain with the required text
		outParser.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "BLOB", buffer.toString().getBytes());

		// End of user code
		// ----------------------------------------------------------

		// The following should only be changed
		// if not propagating message to the 'out' terminal
		out.propagate(outAssembly);
	}
}
