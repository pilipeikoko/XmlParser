package org.epam.xmltask.handler;

import org.epam.xmltask.builder.PostcardBuilder;
import org.epam.xmltask.builder.PostcardBuilderManager;
import org.epam.xmltask.entity.Postcard;
import org.epam.xmltask.entity.PostcardType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CustomXmlHandler extends DefaultHandler {
    private List<Postcard> listOfPostcards;
    private PostcardBuilder postcardBuilder;
    private PostcardType postcardType;

    //todo rename
    private String currentElementContent;

    public CustomXmlHandler(){
        listOfPostcards = new ArrayList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes){
        postcardType = PostcardType.valueOf(qName);
        //todo validator
        PostcardBuilderManager builderManager = new PostcardBuilderManager();
        postcardBuilder = builderManager.createPostcard(postcardType);

        if(postcardBuilder != null){
            IntStream.range(0, attributes.getLength())
                    .forEach(i -> postcardBuilder.addAttribute(attributes.getValue(i)));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if(postcardBuilder != null){

            // currentElementContent != null ?
            postcardBuilder.addElement(currentElementContent);
        }
        if(postcardType != null && postcardType.equals(qName)){

            Postcard currentPostcard = postcardBuilder.createPostcard();
            listOfPostcards.add(currentPostcard);

            postcardType = null;
            //postcardBuilder = null;
        }
    }


    @Override
    public void characters(char[] ch,int start,int length){
        currentElementContent = new String(ch,start,length);
    }

    public List<Postcard> getListOfPostcards() {
        return listOfPostcards;
    }
}
