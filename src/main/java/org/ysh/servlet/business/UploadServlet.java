package org.ysh.servlet.business;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ysh.constants.SysConstants;

import com.jspsmart.upload.Files;
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
			smartUpload.upload(); //准备上传
			smartUpload.save(SysConstants.PATH_UPLOAD); //真实上传
			Files files = smartUpload.getFiles();
			String picName = files.getFile(0).getFileName();
			//另存为
//			files.getFile(0).saveAs("");
			req.setCharacterEncoding("UTF-8");
			req.setAttribute("picName", picName);
			String param = smartUpload.getRequest().getParameter("username");
			System.out.println(param);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("pages/uploadResult.jsp").forward(req, resp);
	}

	
}
