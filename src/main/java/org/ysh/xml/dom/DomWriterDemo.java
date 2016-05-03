package org.ysh.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomWriterDemo {

	private static String[] bookNames={"Java EE","Java Core","Think in Java"};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.newDocument();
		
		Element books = doc.createElement("Books");
		for(int i=0;i<bookNames.length;i++){
			Element book = doc.createElement("Book");
			Element bookName = doc.createElement("name");
			bookName.appendChild(doc.createTextNode(bookNames[i]));
			book.appendChild(bookName);
			books.appendChild(book);
		}
		
		doc.appendChild(books);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		
		Transformer former = tf.newTransformer();
		
		former.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		DOMSource source = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File("D:\\books.xml"));
		former.transform(source, sr);
	}

}
