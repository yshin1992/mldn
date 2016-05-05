package org.ysh.xml;

import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public interface DeptOperation {
	
	public void read() throws SQLException,ParserConfigurationException,TransformerException;
	
	public void write(String filePath) throws SQLException,ParserConfigurationException;
	
}
