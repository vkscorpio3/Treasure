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
public class EmailResponse extends MbJavaComputeNode {

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
		
		// Add the message ID to the email confirmation response
		MbMessage env = inAssembly.getLocalEnvironment();
		MbElement writtenDestination = env.getRootElement().getFirstElementByPath("WrittenDestination");
		MbElement email = writtenDestination.getFirstElementByPath("Email");
		String messageId = (String)email.getFirstElementByPath("messageId").getValue();

		// Clear out any messages 
		outRoot.getLastChild().detach();

		// Confirmation message
		String reply = "Thank you. An email has been sent (messageId " + messageId + ")";

		// Create the Broker Blob Parser element
		MbElement outParser = outRoot.createElementAsLastChild(MbBLOB.PARSER_NAME);
		// Create the BLOB element in the Blob parser domain with the required text
		outParser.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "BLOB", reply.getBytes());

		// End of user code
		// ----------------------------------------------------------

		// The following should only be changed
		// if not propagating message to the 'out' terminal
		out.propagate(outAssembly);
	}
}
