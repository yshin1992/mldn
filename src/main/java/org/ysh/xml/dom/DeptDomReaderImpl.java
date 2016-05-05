package org.ysh.xml.dom;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.ysh.dao.impl.DeptDaoImpl;
import org.ysh.domain.Dept;
import org.ysh.xml.DeptOperation;

public class DeptDomReaderImpl implements DeptOperation {
	
	private DeptDaoImpl deptDao = new DeptDaoImpl();
	
	public void read() throws SQLException, ParserConfigurationException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.newDocument();
		
		Element depts = doc.createElement("Depts");
		List<Dept> deptList = deptDao.reverse(null, false);
		if(null != deptList && deptList.size() > 0){
			for(Dept dept : deptList){
				Element deptElem = doc.createElement("Dept");
				Element deptNoElem = doc.createElement("DeptNo");
				deptNoElem.appendChild(doc.createTextNode(String.valueOf(dept.getDeptNo())));
				
				Element deptNameElem = doc.createElement("DeptName");
				deptNameElem.appendChild(doc.createTextNode(dept.getDeptName()));
				
				Element deptLocElem = doc.createElement("DeptLoc");
				deptLocElem.appendChild(doc.createTextNode(dept.getDeptLoc()));
				
				deptElem.appendChild(deptNoElem);
				deptElem.appendChild(deptNameElem);
				deptElem.appendChild(deptLocElem);
				
				depts.appendChild(deptElem);
			}
		}
		
		doc.appendChild(depts);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		
		Transformer former = tf.newTransformer();
		
		former.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		DOMSource source = new DOMSource(doc);
		StreamResult sr = new StreamResult(new File("D:\\depts.xml"));
		former.transform(source, sr);
		
	}

	public void write(String filePath) {

	}
	

}
