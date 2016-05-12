package org.ysh.constants;

import java.io.IOException;
import java.util.Properties;

public class SysConstants {
	
	private static final String _CFG_FILE = "/cfg.properties";
	
	public static final String PATH_UPLOAD;
	
	static{
		Properties props = new Properties();
		try {
			props.load(SysConstants.class.getResourceAsStream(_CFG_FILE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PATH_UPLOAD = props.getProperty("path.upload");
	}
}
