package util;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLReader {

    public void testParser(){

        try {
           // File inputFile = new File("src/res/runewordFinder.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Document doc = dBuilder.parse(inputFile);
            Document doc = dBuilder.parse(getClass().getClassLoader().getResourceAsStream("res/runewordFinder.xml"));
            doc.getDocumentElement().normalize();

            System.out.println("root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("rune");
            System.out.println("----------------------------");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("current element: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Rune enum name: " + element.getAttribute("label"));
                    System.out.println("rune name: " + element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Weapons: " + element.getElementsByTagName("weapons").item(0).getTextContent());
                    System.out.println("Armor: " + element.getElementsByTagName("armor").item(0).getTextContent());
                    System.out.println("Helms: " + element.getElementsByTagName("helms").item(0).getTextContent());
                    System.out.println("Shields: " + element.getElementsByTagName("shields").item(0).getTextContent());
                    System.out.println("Required Level: " + element.getElementsByTagName("level").item(0).getTextContent());
                }
                System.out.println("++++++++++++++++");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
