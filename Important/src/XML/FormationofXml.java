/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author ganesan
 */
public class FormationofXml {

    public static void main(String f[]) {

        String name = "Ganesan";
        String address = "chennai";
        String contact = "967703396358425693";
        String email = "ganesan@gmail.com";


        try {
            System.out.println(name);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            new FormationofXml().createXmlTree(doc, name, address, contact, email);


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void createXmlTree(Document doc, String name, String address, String contact, String email) throws Exception {
        System.out.println(name);
        Element root = doc.createElement("Student");
        doc.appendChild(root);

        Element child1 = doc.createElement("Name");
        root.appendChild(child1);

        Text text1 = doc.createTextNode(name);
        child1.appendChild(text1);

        Element child2 = doc.createElement("Address");
        root.appendChild(child2);

        Text text2 = doc.createTextNode(address);
        child2.appendChild(text2);

        Element child3 = doc.createElement("ContactNo");
        root.appendChild(child3);

        Text text3 = doc.createTextNode(contact);
        child3.appendChild(text3);

        Element child4 = doc.createElement("Email");
        root.appendChild(child4);

        Text text4 = doc.createTextNode(email);
        child4.appendChild(text4);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");


        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
        String xmlString = sw.toString();
        System.out.println(xmlString);
        File file = new File("C:\\\\Documents and Settings\\\\ganesan\\\\My Documents\\\\NetBeansProjects\\\\Important\\\\web\\\\new.xml");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(xmlString);
        bw.flush();
        bw.close();

    }
}
