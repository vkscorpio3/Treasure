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
public class SetEmailProperties extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");

		MbMessage inMessage = inAssembly.getMessage();

		// create new message
		MbMessage outMessage = new MbMessage();

		// optionally copy message headers
		copyMessageHeaders(inMessage, outMessage);

		// ----------------------------------------------------------
		// Add user code below

		// Get the incoming MIME parts
		MbElement inRoot = inMessage.getRootElement();
		MbElement inMime = inRoot.getFirstElementByPath("MIME");
		MbElement inParts = inMime.getFirstElementByPath("Parts");
		// Create an email output header properties folder
		MbElement outRoot = outMessage.getRootElement();			
		MbElement emailOutputHeader = outRoot.createElementAsLastChild(MbElement.TYPE_NAME, "EmailOutputHeader", null);
		// Then create an email and attachment properties folders in the local environment
		MbMessage env = inAssembly.getLocalEnvironment();
		MbMessage newEnv = new MbMessage(env);			
		MbElement destination = newEnv.getRootElement().createElementAsLastChild(MbElement.TYPE_NAME, "Destination", null);
		MbElement email = destination.createElementAsLastChild(MbElement.TYPE_NAME, "Email", null);
		MbElement attachment = email.createElementAsLastChild(MbElement.TYPE_NAME, "Attachment", null);
		// This is the message
		String reply = "";
		// This is a metaheader
		String xheader = null; 
		// This is the byte string conversion 
		String dataString = null;
		// Get the first part
		MbElement part = inParts.getFirstChild();
		// Iterate through all of the parts dynamically setting broker email properties
		while (part != null) {
			// Strip out the email property 
			String content = (String)part.getFirstChild().getValue();
			int start = content.indexOf("\"") + 1;
			int end = content.indexOf("\"", start);
			String property = content.substring(start, end);
			// Get the corresponding property data
			MbElement data = part.getLastChild().getFirstElementByPath("BLOB");
			// If there is a data part then setup the relevant email property overrides
			if (data != null) {
				// Obtain the byte data
				byte[] blobData = (byte[])data.getFirstElementByPath("BLOB").getValue(); 
				// Convert to a string only if it is not an attachment
				if (!property.equals("Content")) dataString = new String(blobData);
				// Set email addresses
				if (property.equals("To") || property.equals("Cc") || property.equals("Bcc") || property.equals("From") || property.equals("Reply-To") || property.equals("Subject")) emailOutputHeader.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, property, dataString);
				// Set the metadata
				else if (property.equals("XHeader")) xheader = dataString;
				else if (property.equals("Value") && xheader != null) emailOutputHeader.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, xheader, dataString);
				// Set SMTP info
				else if (property.equals("SMTPServer") || property.equals("SecurityIdentity") || property.equals("BodyContentType") || property.equals("MultipartContentType")) email.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, property, dataString); 
				// Set the message
				else if (property.equals("Message")) reply = dataString;
				// Read in the file attachment
				else if (property.equals("Content")) attachment.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, property, blobData);
				// Set the attachment attributes
				else if (property.equals("ContentName") || property.equals("ContentType") || property.equals("ContentEncoding")) attachment.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, property, dataString);					
			}
			// Get the next part
			part = part.getNextSibling();
		}
			
		// Create the new assembly with the new email property overrides
		MbMessageAssembly outAssembly = new MbMessageAssembly(
				inAssembly,
				newEnv,
				inAssembly.getExceptionList(),
				outMessage);
		
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

	public void copyMessageHeaders(MbMessage inMessage, MbMessage outMessage)
			throws MbException {
		MbElement outRoot = outMessage.getRootElement();

		// iterate though the headers starting with the first child of the root
		// element
		MbElement header = inMessage.getRootElement().getFirstChild();
		while (header != null && header.getNextSibling() != null) // stop before
		// the last
		// child
		// (body)
		{
			// copy the header and add it to the out message
			outRoot.addAsLastChild(header.copy());
			// move along to next header
			header = header.getNextSibling();
		}
	}
}

