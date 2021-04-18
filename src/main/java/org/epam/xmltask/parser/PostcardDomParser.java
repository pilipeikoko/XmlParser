package org.epam.xmltask.parser;

import org.epam.xmltask.builder.PostcardBuilder;
import org.epam.xmltask.builder.PostcardBuilderManager;
import org.epam.xmltask.exception.CustomXmlParserException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PostcardDomParser extends PostcardParser {

    private PostcardBuilder postcardBuilder;

    public PostcardDomParser() {
        super();
    }

    @Override
    public void createListOfPostcards(String path) throws CustomXmlParserException {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();


            //todo parse the file, not path?
            Document document = documentBuilder.parse(path);

            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();

            int i = 0;

            while (i < nodeList.getLength()) {
                if (nodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Node currentNode = nodeList.item(i);

                String currentNodeName = currentNode.getNodeName();

                PostcardBuilderManager builderManager = new PostcardBuilderManager();

                postcardBuilder = builderManager.createPostcard(currentNodeName);

                setInfo(currentNode);

                ++i;
            }
            //todo rename messages
        } catch (ParserConfigurationException exception){
            throw new CustomXmlParserException("Parser configuration exception",exception.getCause());
        } catch (SAXException exception){
            throw new CustomXmlParserException("SAX exception",exception.getCause());
        } catch (IOException exception){
            throw new CustomXmlParserException("IOE exception", exception.getCause());
        }
    }

    private void setInfo(Node currentNode) {

        //todo cast to Element?
        addElements(currentNode);
        addAttributes(currentNode);

        listOfPostcards.add(postcardBuilder.createPostcard());

    }

    private void addAttributes(Node currentNode) {
        NamedNodeMap attributes = currentNode.getAttributes();

        for (int i = 0; i < attributes.getLength(); i++) {
            Node currentAttribute = attributes.item(i);
            postcardBuilder.addAttribute(currentAttribute.getTextContent());
        }
    }

    private void addElements(Node currentNode) {
        NodeList elements = currentNode.getChildNodes();

        int i = 0;
        while (i < elements.getLength()) {
            if (elements.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
                //todo repalce with private method
            }

            Node currentElement = elements.item(i++);

            postcardBuilder.addElement(currentElement.getTextContent());
        }

    }
}
