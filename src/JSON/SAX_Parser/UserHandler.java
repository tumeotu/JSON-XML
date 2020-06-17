package JSON.SAX_Parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class UserHandler extends DefaultHandler {

    public StringBuilder content = null;
    public Student student = null;
    public List<Student> studentList = null;

    boolean bName = false;
    boolean bCode = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            String ID = attributes.getValue("id");
            student= new Student();
            student.ID = ID;
            if (studentList == null)
                studentList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("code")) {
            bCode = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
        content = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            student.Name = content.toString();
            bName = false;
        } else if (bCode) {
            student.Code = content.toString();
            bCode = false;
        }
        else if (bAge) {
            student.Age = Integer.parseInt(content.toString());
            bAge = false;
        }
        if (qName.equalsIgnoreCase("student")) {
                studentList.add(student);
            }
    }
    @Override
    public void characters ( char ch[], int start, int length) throws SAXException {
        content.append(new String(ch,start,length));
    }
}