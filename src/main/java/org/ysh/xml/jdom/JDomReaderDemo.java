package org.ysh.xml.jdom;

import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * 为减少DOM、SAX的编码量，出现了JDOM；优点：20-80原则，极大减少了代码量。
 * 使用场合：要实现的功能简单，如解析、创建等，但在底层，JDOM还是使用SAX（最常用）、DOM、Xanan文档。
 * JDOM解析XML文档所使用到的jar包：jdom.jar
 * JDOM = DOM修改文件的优点+SAX快速读取的优点
 * @author Administrator
 * 
 */
public class JDomReaderDemo {

	private static final String PATH_XML = "/xml/books.xml";
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(JDomReaderDemo.class.getResourceAsStream(PATH_XML));
		Element books = doc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> list = books.getChildren("Book");
		Iterator<Element> iter = list.iterator();
		while(iter.hasNext()){
			Element elem = iter.next();
			System.out.println(elem.getChildText("name"));
		}
	}

}
