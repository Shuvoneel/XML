package exampleOne.fromJava;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FromXmlToJava {

    public static void main(String[] args) {
        try {
            File input = new File("E:\\1246913\\XML\\dayOne\\src\\exampleOne\\fromJava\\one.xml");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(input);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Employee");
            System.out.println("-----------------------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Employee ID: " + eElement.getAttribute("id"));
                    System.out.println("Employee Position: " + eElement.getElementsByTagName("position").item(0).getTextContent());
                    System.out.println("FirstName: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Lastname: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nickname: " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary: " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                    System.out.println("Email: " + eElement.getElementsByTagName("email").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
