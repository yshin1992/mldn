package org.ysh.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 使用DOM解析XML
 * 解析器读入整个文档，然后构建一个驻留内存的树结构，然后代码就可以使用 DOM 接口来操作这个树结构。
 * 优点：整个文档树在内存中，便于操作；支持删除、修改、重新排列等多种功能；
 * 缺点：将整个文档调入内存（包括无用的节点），浪费时间和空间；
 * 使用场合：一旦解析了文档还需多次访问这些数据；硬件资源充足（内存、CPU）。 
 * @author Administrator
 *
 */
public class DomReaderDemo {

	private static final String PATH_XML = "/xml/books.xml";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document doc = builder.parse(DomReaderDemo.class.getResourceAsStream(PATH_XML));
			NodeList nodeList = doc.getElementsByTagName("name");
			int size = nodeList.getLength();
			for(int i=0;i<size;i++)
			{
				Node node = nodeList.item(i);
				System.out.println(node.getFirstChild().getNodeValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
