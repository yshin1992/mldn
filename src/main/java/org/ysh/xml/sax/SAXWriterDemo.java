package org.ysh.xml.sax;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;

public class SAXWriterDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Result resultXml = new StreamResult(new FileOutputStream(new File("D:\\cities.xml")));
		SAXTransformerFactory sff = (SAXTransformerFactory)SAXTransformerFactory.newInstance();
		TransformerHandler handler = sff.newTransformerHandler();
		Transformer transformer = handler.getTransformer();
		
		transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
		
		handler.setResult(resultXml);
		handler.startDocument();
		AttributesImpl atts = new AttributesImpl();
		handler.startElement("", "", "Country", atts);
		handler.startElement("", "", "China", atts);
		handler.startElement("","","City",atts);
		String peking = "北京";
		handler.characters(peking.toCharArray(), 0, peking.length());
		handler.endElement("", "", "City");
		
		AttributesImpl atts2 = new AttributesImpl();
		atts2.addAttribute("", "", "id", "String", "shanghai");
		handler.startElement("","","City",atts2);
		String shanghai = "上海";
		handler.characters(shanghai.toCharArray(), 0, shanghai.length());
		handler.endElement("", "", "City");
		handler.endElement("", "", "China");
		handler.endElement("", "", "Country");
		handler.endDocument();
	}

}
