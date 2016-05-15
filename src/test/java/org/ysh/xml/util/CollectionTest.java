package org.ysh.xml.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class CollectionTest {
	
	public static void main(String[] args)
	{
		int[] intArr = {1,2,3};
		if(intArr.getClass().isArray())
		{
			System.out.println(intArr[0]);
		}
		Map<String,String> strMap = new HashMap<String,String>();
		Object val = strMap;
		Class[] interfaces = val.getClass().getInterfaces();
		if(null != interfaces && interfaces.length>0)
		{
			for(Class clazz : interfaces)
			{
				if(Map.class == clazz)
				{
					System.out.println("map instanceof collection");
					break;
				}else if(List.class == clazz)
				{
					
				}
					
			}
		}
	}
}
