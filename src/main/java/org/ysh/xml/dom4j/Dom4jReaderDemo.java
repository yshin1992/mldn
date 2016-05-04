package org.ysh.xml.dom4j;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jReaderDemo {

	private static final String PATH_XML = "/xml/books.xml";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Document doc = new SAXReader().read(Dom4jReaderDemo.class.getResourceAsStream(PATH_XML));
		Element root = doc.getRootElement();
		Iterator<Element> iter = root.elementIterator("Book");//取得其全部的子节点
		while(iter.hasNext()){
			Element elem = iter.next(); //Book子节点
			System.out.println(elem.elementText("name"));
		}
	}

}
