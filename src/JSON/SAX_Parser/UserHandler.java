package JSON.SAX_Parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {

    boolean bName = false;
    boolean bCode = false;
    boolean bAge = false;

    @Override
    public void startElement() throws SAXException {
        System.out.println("abc");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            String ID = attributes.getValue("id");
            System.out.println("ID : " + ID);
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("code")) {
            bCode = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }
    @Override
    public void endElement(String uri,String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            System.out.println("-----------------");
        }
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        } else if (bCode) {
            System.out.println("Code: " + new String(ch, start, length));
            bCode = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}