package org.ysh.xml.dom;

import org.ysh.xml.DeptOperation;

public class EmplDomWriterTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DeptOperation operate = new DeptDomReaderImpl();
		operate.write("/home/yshin1992/depts.xml");
	}	

}
