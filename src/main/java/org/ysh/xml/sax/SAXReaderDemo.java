package org.ysh.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 为解决DOM的问题，出现了SAX。SAX ，事件驱动。当解析器发现元素开始、元素结束、文本、文档的开始或结束等时，发送事件，程序员编写响应这些事件的代码，保存数据。
 * 优点：不用事先调入整个文档，占用资源少；SAX解析器代码比DOM解析器代码小，适于Applet，下载。
 * 缺点：不是持久的；事件过后，若没保存数据，那么数据就丢了；无状态性；从事件中只能得到文本，但不知该文本属于哪个元素；
 * 使用场合：Applet;只需XML文档的少量内容，很少回头访问；机器内存少；
 * SAX解析XML文档所使用到的jar包：sax.jar
 * @author Administrator
 *
 */
public class SAXReaderDemo {

	private static final String PATH_XML = "/xml/books.xml";
	
	public static void main(String[] args) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser parser = factory.newSAXParser();
		
		parser.parse(SAXReaderDemo.class.getResourceAsStream(PATH_XML), new SAXReaderHandler());
	}
}

class SAXReaderHandler extends DefaultHandler{

	/**
	 * 文档中的文本内容
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(new String(ch,start,length));
	}

	/**
	 * 文档结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("读取文档结束");
	}

	/**
	 * 元素节点结束
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("</"+qName+">");
	}

	/**
	 * 文档开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("读取文档开始");
	}

	/**
	 * 元素节点开始
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.print("\r\n<");
		System.out.print(qName);
		int lens = attributes.getLength();
		for(int i=0;i<lens;i++)
		{
			System.out.print(" "+attributes.getQName(i)+"=\""+attributes.getValue(i)+"\"");
		}
		System.out.print(">");
	}
	
}