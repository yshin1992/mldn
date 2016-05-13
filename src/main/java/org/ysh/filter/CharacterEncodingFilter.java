package org.ysh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符编码过滤器
 * @author Administrator
 *
 */
public class CharacterEncodingFilter implements Filter {

	private String charset;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.charset = filterConfig.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.charset);
		chain.doFilter(request, response);
//		response.setCharacterEncoding("UTF-8");
	}

	@Override
	public void destroy() {

	}

}
