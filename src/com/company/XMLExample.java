package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLExample {
    private static boolean isFound;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SearchingXMLHandler handler = new SearchingXMLHandler("ShowPlanXML");
        parser.parse(new File("C:\\Users\\Gaukhartas\\IdeaProjects\\untitled5\\src\\com\\company\\resource\\Execution_plan.xml"), handler);

        if(!isFound)
            System.out.println("Element was not found");
    }
    private static class SearchingXMLHandler extends DefaultHandler{
        private String element;
        private boolean isEntered;

        public SearchingXMLHandler(String element){
            this.element = element;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if(isEntered){
                System.out.println(String.format("Element <%s> is found, its attributes: ", qName));
                int length = attributes.getLength();
                for (int i=0; i <length; i++){
                    System.out.println(String.format("Name of the attribute: %s, its value: %s", attributes.getQName(i), attributes.getValue(i)));
                }

            }
            if(qName.equals(element)){
                isEntered = true;
                isFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equals(element)){
                isEntered = false;
            }
        }
    }
    }

