package org.ysh.servlet.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ysh.constants.SysConstants;
import org.ysh.servlet.tools.FileUploadTools;

public class CommonUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("pages/fileupload.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		FileUploadTools uploadTools = new FileUploadTools(req, -1, null);
		String username = uploadTools.getParameter("username");
		req.setAttribute("username", username);
		try {
			uploadTools.saveAll(SysConstants.PATH_UPLOAD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("picName", uploadTools.getUploadFiles().keySet().iterator().next());
		req.getRequestDispatcher("pages/uploadResult.jsp").forward(req, resp);
	}

	
}
