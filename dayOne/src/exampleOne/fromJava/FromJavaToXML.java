package exampleOne.fromJava;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FromJavaToXML {

    public static void main(String argv[]) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Company");
            doc.appendChild(rootElement);

            //  employee elements
            Element employee = doc.createElement("Employee");
            rootElement.appendChild(employee);

            // set attribute "id" to employee element
            Attr id = doc.createAttribute("id");
            id.setValue("100");
            employee.setAttributeNode(id);

            // position elements
            Element position = doc.createElement("position");
            position.appendChild(doc.createTextNode("Manager"));
            employee.appendChild(position);

            // firstname elements
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("Mehedi"));
            employee.appendChild(firstname);

            // lastname elements
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("Hasan"));
            employee.appendChild(lastname);

            // nickname elements
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("Shuvo"));
            employee.appendChild(nickname);

            // salary elements
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("1,00,000"));
            employee.appendChild(salary);

            // email elements
            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode("mhshuvo@gmail.com"));
            employee.appendChild(email);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("E:\\1246913\\XML\\dayOne\\src\\exampleOne\\fromJava\\one.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
