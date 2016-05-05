package org.ysh.xml.dom;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.w3c.dom.NodeList;
import org.ysh.dao.impl.DeptDaoImpl;
import org.ysh.dao.impl.EmpDaoImpl;
import org.ysh.domain.Dept;
import org.ysh.domain.Employee;
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
		StreamResult sr = new StreamResult(new File("/home/yshin1992/depts.xml"));
		former.transform(source, sr);
		
	}

	public void write(String filePath) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File(filePath));
		NodeList empnos = doc.getElementsByTagName("empno");
		NodeList enames = doc.getElementsByTagName("ename");
		NodeList jobs = doc.getElementsByTagName("job");
		NodeList hiredates = doc.getElementsByTagName("hiredate");
		NodeList sals = doc.getElementsByTagName("sal");
		NodeList comms =doc.getElementsByTagName("comm");
		List<Employee> empList=new ArrayList<Employee>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(null != empnos && empnos.getLength() > 0){
			for(int i=0,lens=empnos.getLength();i<lens;i++){
				Employee emp = new Employee();
				emp.setEmpNo(Integer.valueOf(empnos.item(i).getFirstChild().getNodeValue()));
				emp.setEmpName(enames.item(i).getFirstChild().getNodeValue());
				emp.setJob(jobs.item(i).getFirstChild().getNodeValue());
				emp.setHireDate(sdf.parse(hiredates.item(i).getFirstChild().getNodeValue()));
				emp.setSal(Double.valueOf(sals.item(i).getFirstChild().getNodeValue()));
				emp.setComm(Double.valueOf(comms.item(i).getFirstChild().getNodeValue()));
				empList.add(emp);
			}
		}
		if(empList.size() > 0){
			EmpDaoImpl empDao = new EmpDaoImpl();
			empDao.batchCreate(empList);
		}
	}
	

}
