package util;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import runes.Rune;
import runes.Runeword;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XMLReader {

    private Document document;

    public XMLReader() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("res/runewordFinder.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Document doc = dBuilder.parse(inputFile);
            document = dBuilder.parse(inputStream);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getXMLRuneProp(Rune rune) {
        String properties = "";

        NodeList nodeList = document.getElementsByTagName("rune");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getAttribute("label").equals(rune.toString())) {
                    properties = element.getElementsByTagName("name").item(0).getTextContent() + " Rune\n";
                    properties += "Weapons: " + element.getElementsByTagName("weapons").item(0).getTextContent() + "\n";
                    properties += "Armor: " + element.getElementsByTagName("armor").item(0).getTextContent() + "\n";
                    properties += "Helms: " + element.getElementsByTagName("helms").item(0).getTextContent() + "\n";
                    properties += "Shields: " + element.getElementsByTagName("shields").item(0).getTextContent() + "\n";
                    properties += "Required level: " + element.getElementsByTagName("level").item(0).getTextContent();
                }
            }
        }

        return properties;
    }

    public void testParser(){

        try {
            /*
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("res/runewordFinder.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();
            */

            System.out.println("root element: " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("rune");
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

    public String getXMLRunewordProp(Runeword runeword) {
        String properties = "";

        NodeList nodeList = document.getElementsByTagName("runeword");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getAttribute("label").equals(runeword.toString())) {
                    properties = element.getElementsByTagName("properties").item(0).getTextContent();
                }
            }
        }

        return properties;
    }
}
