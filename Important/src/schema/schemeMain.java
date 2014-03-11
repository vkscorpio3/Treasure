package schema;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class schemeMain {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		schemeMain m = new schemeMain();
		//m.validWebDOTXML();
		m.validXMLUSINGXSD();

	}

	void validWebDOTXML() throws SAXException, IOException {
		URL schemaFile = new URL(
				"http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd");
		Source xmlFile = new StreamSource(
				new File("/home/ganesan/git/Treasure/Important/WebContent/WEB-INF/web.xml"));
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		try {
			validator.validate(xmlFile);
			System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (SAXException e) {
			System.out.println(xmlFile.getSystemId() + " is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
		}
	}

	
	void validXMLUSINGXSD() throws SAXException, IOException, ParserConfigurationException {
		Source xmlFile = new StreamSource(new File("src/schema/contact.xml"));
		 
		//Lookup a factory for the W3C XML Schema language
		 SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		 
		 // Compile the schema.
		 // Here the schema is loaded from a java.io.File, but you could use
		 // a java.net.URL or a javax.xml.transform.Source instead.
		 File schemaLocation = new File("src/schema/contact.xsd");
		 Schema schema = schemaFactory.newSchema(schemaLocation);
		 
		try {
		 // Get a validator from the schema.
		 Validator validator = schema.newValidator();
		 validator.validate(xmlFile);
		 System.out.println(xmlFile.getSystemId() + " is valid");
		 
		} catch (SAXParseException e) {
		 System.out.println(xmlFile.getSystemId() + " is NOT valid");
		 System.out.println("Reason\t\t: " + e.getLocalizedMessage());
		 System.out.println("Line Number \t: " + e.getLineNumber());
		 System.out.println("Column Number\t: " + e.getColumnNumber());
		 System.out.println("Public Id\t: " + e.getPublicId());
		 
		} catch (SAXException e) {
		 System.out.println(xmlFile.getSystemId() + " is NOT valid");
		 System.out.println("Reason\t: " + e.getLocalizedMessage());
		 }
	}
}
