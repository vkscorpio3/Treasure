<%-- 
    Document   : xml
    Created on : Jul 19, 2011, 2:39:08 PM
    Author     : ganesan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.io.*,org.w3c.dom.*,javax.xml.parsers.*,javax.xml.transform.*, javax.xml.transform.dom.*,javax.xml.transform.stream.*"%>

<%!
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

        File file = new File("C:\\\\Documents and Settings\\\\ganesan\\\\My Documents\\\\NetBeansProjects\\\\Important\\\\web\\\\new.xml");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(xmlString);
        bw.flush();
        bw.close();

    }%>


<%
        String name = "roseindia";
        String address = "Delhi";
        String contact = "111111";
        String email = "aa@roseindia.net";


        try {
            System.out.println(name);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            createXmlTree(doc, name, address, contact, email);

            out.println("<b>Xml File Created Successfully</b>");
        } catch (Exception e) {
            System.out.println(e);
        }

%>
