package org.epam.xmltask.parser;

import org.epam.xmltask.builder.PostcardBuilder;
import org.epam.xmltask.builder.PostcardBuilderManager;
import org.epam.xmltask.exception.CustomXmlParserException;
import org.epam.xmltask.validator.OldCardsEnumValidator;
import org.epam.xmltask.validator.OldCardsXmlValidator;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class PostcardDomParser extends PostcardParser {

    private PostcardBuilder postcardBuilder;

    public PostcardDomParser() {
        super();
    }

    @Override
    public void createListOfPostcards(String path) throws CustomXmlParserException {

        OldCardsXmlValidator.validateXml(path);

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

            File file = new File(ClassLoader.getSystemResource(path).getPath());
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();


            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Node elementNode = nodeList.item(i);

                String currentNodeName = elementNode.getNodeName();

                if (OldCardsEnumValidator.isPostcardTypeCorrect(currentNodeName)) {

                    PostcardBuilderManager builderManager = new PostcardBuilderManager();

                    postcardBuilder = builderManager.createPostcard(currentNodeName.replaceAll("-", "_"));

                    setInfo(elementNode);
                }

            }
            LOGGER.info("Parsed successfully. Amount of found objects: " + listOfPostcards.size());
        } catch (ParserConfigurationException exception) {
            throw new CustomXmlParserException("Configuration error", exception.getCause());
        } catch (SAXException exception) {
            throw new CustomXmlParserException("SAX exception", exception.getCause());
        } catch (IOException exception) {
            throw new CustomXmlParserException("IOE exception", exception.getCause());
        }
    }

    private void setInfo(Node currentNode) {

        NamedNodeMap attributeMap = currentNode.getAttributes();
        for (int i = 0; i < attributeMap.getLength(); i++) {
            Node attribute = attributeMap.item(i);
            postcardBuilder.addAttribute(attribute.getTextContent());
        }

        NodeList childElements = currentNode.getChildNodes();
        for (int i = 0; i < childElements.getLength(); i++) {
            if (childElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Node currentElement = childElements.item(i);
            postcardBuilder.addElement(currentElement.getTextContent());
        }
        listOfPostcards.add(postcardBuilder.createPostcard());

    }
}
