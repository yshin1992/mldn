package org.ysh.servlet.business;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ServletConfig config;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.config = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("pages/smartupload.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(config,req,resp);
		try {
			smartUpload.upload();
			smartUpload.save("D:\\home");
			String param = smartUpload.getRequest().getParameter("username");
			System.out.println(param);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("pages/uploadResult.jsp").forward(req, resp);
	}

	
}
