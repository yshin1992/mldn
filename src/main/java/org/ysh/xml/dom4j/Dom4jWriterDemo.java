package org.ysh.xml.dom4j;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jWriterDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Document doc = DocumentHelper.createDocument();
		Element rootElement = doc.addElement("Cities");
		Element city1 = rootElement.addElement("city");
		city1.addAttribute("cityId", "1003");
		Element name1 = city1.addElement("name");
		name1.setText("上海");
		Element city2 = rootElement.addElement("city");
		city2.addAttribute("cityId", "1001");
		Element name2 = city2.addElement("name");
		name2.setText("北京");
		
		OutputFormat of = OutputFormat.createPrettyPrint();
		of.setEncoding("utf-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File("D:\\cities3.xml")));
		writer.write(doc);
		writer.close();
	}

}
