package org.ysh.xml.jdom;

import java.io.File;
import java.io.FileOutputStream;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class JDomWriterDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Element cities = new Element("Cities");
		Element city1 = new Element("City");
		city1.setText("上海");
		city1.setAttribute(new Attribute("id", "shanghai"));
		cities.addContent(city1);
		Element city2 = new Element("City");
		city2.setText("北京");
		city2.setAttribute(new Attribute("id", "beijing"));
		cities.addContent(city2);
		Document doc = new Document(cities);
		XMLOutputter output = new XMLOutputter();
		output.setFormat(output.getFormat().setEncoding("utf-8"));
		output.output(doc, new FileOutputStream(new File("D:\\cities2.xml")));
	}

}
