package util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import runes.Rune;
import runes.Runeword;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.IllegalCharsetNameException;
import java.util.EnumMap;

public class XMLReader {


    //TODO "arrows" are looking bad - need to change it somehow
    private static Document getDocument(String fileDirectory) {
        Document document = null;

        try {
            XMLReader reader = new XMLReader();
            InputStream inputStream = reader.getClass().getClassLoader().getResourceAsStream(fileDirectory);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(inputStream);
            document.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static String getRunePropertiesFromXML(Rune rune, String fileDirectory) {
        String properties = "";

        Document document = getDocument(fileDirectory);
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

    public static String getRunewordPropertiesFromXML(Runeword runeword, String fileDirectory) {
        String properties = "";

        Document document = getDocument(fileDirectory);
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

    public static EnumMap<Rune, Integer> getPlayerRunesFromXML (String fileDirectory) {

        EnumMap<Rune, Integer> playerRunes = new EnumMap<>(Rune.class);
        Document document = getDocument(fileDirectory);
        NodeList nodeList = document.getElementsByTagName("rune");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                for (Rune rune : Rune.values()) {
                    if (element.getAttribute("label").equals(rune.toString())) {
                        int runeAmount = Integer.parseInt(element.getElementsByTagName("amount").item(0).getTextContent());
                        playerRunes.put(rune, runeAmount);
                    }
                }
            }
        }


        return playerRunes;
    }
}
