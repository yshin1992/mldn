package org.ysh.servlet.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ysh.domain.LoginUser;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 用户验证
		 * 略
		 */
		LoginUser loginUser = new LoginUser();
		loginUser.setUsername(req.getParameter("username"));
		req.getSession().setAttribute("loginUser", loginUser);
		req.getRequestDispatcher("pages/result.jsp").forward(req, resp);
	}

	
}
