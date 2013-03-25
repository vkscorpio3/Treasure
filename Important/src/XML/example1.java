/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ganesan
 */
public class example1 {

    public static void main(String a[]) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
        DocumentBuilder docbul = db.newDocumentBuilder();
        Document doc = docbul.parse("src\\\\java\\\\XML\\\\example.xml");
        Element ele = doc.getDocumentElement();
        ele.normalize();
        System.out.println("Tage name " + ele.getTagName());
        System.out.println("Node Name " + ele.getNodeName());
        System.out.println("Node type " + ele.getNodeType());
        System.out.println("Value " + ele.getNodeValue());

        System.out.println("Attribute =" + ele.getAttribute("val"));
        System.out.println(ele.getAttributeNode("val"));
        ele.setAttribute("Hi", "bye");
        System.out.println(ele.getAttribute("Hi"));

        Node one = ele.getFirstChild();
        System.out.println(one.getNodeName());
        System.out.println(one.getNodeType());
        System.out.println(one.getLocalName());

        NodeList nodelist = doc.getElementsByTagName("first");
        System.out.println("Length " + nodelist.getLength());
        Node node = nodelist.item(0);
        System.out.println(node.getNodeName());
        Element e = (Element) node;
        NodeList nodelistSub = e.getElementsByTagName("name");

        Element ee = (Element) nodelistSub.item(0);
        NodeList nl = ee.getChildNodes();
        Node n = nl.item(0);
        System.out.println(n.getNodeValue());


        System.out.println("//////////////////////////");
        Node nodesub = nodelistSub.item(0);
        System.out.println("Node name " + nodesub.getNodeName());
        System.out.println("Node value " + nodesub.getNodeValue());


        NodeList firstNameList = doc.getElementsByTagName("name");
        Element firstNameElement = (Element) firstNameList.item(0);

        NodeList textFNList = firstNameElement.getChildNodes();
        System.out.println("First Name : " +
                ((Node) textFNList.item(0)).getNodeValue().trim());




        NodeList ndlist = ele.getChildNodes();
        System.out.println(ndlist.getLength());
        for (int i = 0; i < ndlist.getLength(); i++) {
            System.out.println(ndlist.item(i).getNodeName());
                        System.out.println("7777  "+((Node)ndlist.item(i)).getNodeName());

                        System.out.println("eerer  "+((Node)ndlist.item(i)).getNodeValue());


        }




    }
}
