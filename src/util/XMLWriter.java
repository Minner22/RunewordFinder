package util;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import runes.Rune;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.EnumMap;
import java.util.Map;

public class XMLWriter {

    //TODO it has to write it to file, for now just prints xml to console
    public static void savePlayersRunesToXML(EnumMap<Rune, Integer> playerRunes, String outputFileDirectory) {

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("runewordFinder");
            document.appendChild(root);

            for (Map.Entry<Rune, Integer> entry : playerRunes.entrySet()) {

                Rune key = entry.getKey();
                Integer runeAmount = entry.getValue();
                Element rune = document.createElement("rune");
                root.appendChild(rune);

                Attr attr = document.createAttribute("label");
                attr.setValue(key.toString());
                rune.setAttributeNode(attr);

                Element amount = document.createElement("amount");
                amount.appendChild(document.createTextNode(String.valueOf(runeAmount)));
                rune.appendChild(amount);
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }

}
