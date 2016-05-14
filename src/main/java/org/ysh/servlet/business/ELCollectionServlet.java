package org.ysh.servlet.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ELCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> strList = new ArrayList<String>();
		strList.add("java ee");
		strList.add("java se");
		strList.add("java me");
		request.setAttribute("list", strList);
		Map<String,String> strMap = new HashMap<String,String>();
		strMap.put("struts2", "struts2");
		strMap.put("spring","spring");
		strMap.put("hibernate", "hibernate");
		request.setAttribute("map", strMap);
		request.getRequestDispatcher("el/ELCollection.jsp").forward(request, response);
	}

}
