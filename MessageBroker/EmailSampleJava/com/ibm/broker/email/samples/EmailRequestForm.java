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
public class EmailRequestForm extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");

		MbMessage inMessage = inAssembly.getMessage();

		// create new message
		MbMessage outMessage = new MbMessage();
		MbMessageAssembly outAssembly = new MbMessageAssembly(inAssembly,
				outMessage);

		try {
			// optionally copy message headers
			copyMessageHeaders(inMessage, outMessage);

			// ----------------------------------------------------------
			// Add user code below			

			// Create the html email request form
			StringBuffer html = new StringBuffer();
			html.append("<HTML><HEAD>");
			html.append("<META http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'></HEAD>");				  
			html.append("<BODY><form action='/sample' enctype='multipart/form-data' method=post>");
			html.append("<table cellpadding=4 cellspacing=2 border=0>");
			html.append("<tr><td><b>SMTP Server<sup>*</sup></b></td>");
			html.append("<td><input type='text' name='SMTPServer' size=50 maxlength=100></td></tr>");
			html.append("<tr><td><b>To<sup>*</sup></b></td>");
			html.append("<td><input type='text' name='To' size=50 maxlength=100></td></tr>");
			html.append("<tr><td><b>From<sup>*</sup></b></td>");
			html.append("<td><input type='text' name='From' size=50 maxlength=100></td></tr>");
			html.append("<tr><td><b>Cc</b></td>");
			html.append("<td><input type='text' name='Cc' size=50 maxlength=100></td></tr>");
			html.append("<tr><td><b>Bcc</b></td>");
			html.append("<td><input type='text' name='Bcc' size=50 maxlength=100></td></tr>");
			html.append("<tr><td><b>Reply-To</b></td>");
			html.append("<td><input type='text' name='Reply-To' size=50 maxlength=100></td></tr>");
			html.append("<tr><td><b>Subject</b></td>");
			html.append("<td><input type='text' name='Subject' size=50 maxlength=100></td></tr>");
			html.append("<tr><td/><td>Plain<input type='radio' name='BodyContentType' value='text/plain' checked>");
			html.append("HTML<input type='radio' name='BodyContentType' value='text/html'>");
			html.append("XML<input type='radio' name='BodyContentType' value='text/xml'></td></tr>");
			html.append("<tr><td><b>Message</b></td>");
			html.append("<td><textarea rows=10 cols=50 name='Message'></textarea></td></tr>");
			html.append("<tr><td><b>Multipart Content Type</b></td>");
			html.append("<td><select name='MultipartContentType'>");
			html.append("<option value=''></option>");
			html.append("<option value='alternative'>alternative</option>");
			html.append("<option value='related'>related</option>");
			html.append("<option value='mixed'>mixed</option>");
			html.append("</select></td></tr>");
			html.append("<tr><td><b>Attachment</b></td>");
			html.append("<td><input type='file' name='Content' size=20</td></tr>");
			html.append("<tr><td><b>Attachment Content Type</b></td>");
			html.append("<td><select name='ContentType'>");
			html.append("<option value=''></option>");
			html.append("<option value='text/xml'>text/xml</option>");
			html.append("<option value='text/plain'>text/plain</option>");
			html.append("<option value='text/html'>text/html</option>");
			html.append("<option value='application/octet-stream'>application/octet-stream</option>");
			html.append("</select></td></tr>");
			html.append("<tr><td><b>Attachment Content Name</b></td>");
			html.append("<td><input type='text' name='ContentName' size=50 maxlength=100></td></tr>");
			html.append("<tr><td><b>Attachment Content Encoding</b></td>");
			html.append("<td><select name='ContentEncoding'>");
			html.append("<option value=''></option>");
			html.append("<option value='7bit'>7bit</option>");
			html.append("<option value='base64'>base64</option>");
			html.append("<option value='qouted-printable'>quoted-printable</option>");
			html.append("</select></td></tr>");
			html.append("<tr><td><b>X-Header</b></td>");
			html.append("<td><input type='text' name='XHeader' size=50 maxlength=100></td>");
			html.append("<td><b>Value</b></td>");
			html.append("<td><input type='text' name='Value' size=50 maxlength=100></td></tr>");
			html.append("<tr><td/><td><input type='submit' name='submit' value='Submit'></td></tr>");
			html.append("</table></form></BODY></HTML>");
						
			// Set the content type to be html so that it may be viewed by a browser
            MbElement root = outMessage.getRootElement();			
			MbElement properties = root.getFirstElementByPath("Properties");	
			MbElement contentType = properties.getFirstElementByPath("ContentType");			
			contentType.setValue("text/html");		
			
			// Add the email request form as the message content and publish
			MbElement BLOB = root.createElementAsLastChild(MbBLOB.PARSER_NAME);			
			BLOB.createElementAsFirstChild(MbElement.TYPE_NAME_VALUE, "BLOB", html.toString().getBytes());
			// ----------------------------------------------------------

			// The following should only be changed
			// if not propagating message to the 'out' terminal
			out.propagate(outAssembly);

		} catch (Exception e) {
			throw new MbRecoverableException(
					EmailRequestForm.class.getName(),
					"evaluate()",
					null,
					null,
					e.getMessage(),
					null);
		} finally {

			// clear the outMessage even if there's an exception
			outMessage.clearMessage();
		}
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

