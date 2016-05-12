package org.ysh.servlet.business;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ysh.constants.SysConstants;

public class ShowPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//图片中文乱码解决方法
		String picName = new String(req.getParameter("picName").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(picName);		
		if(null != picName && !("").equals(picName)){
			ServletOutputStream out = resp.getOutputStream();
			
			RandomAccessFile raf = new RandomAccessFile(SysConstants.PATH_UPLOAD + picName, "r");
			
			FileChannel sourceChannel = raf.getChannel();
			
			WritableByteChannel destChannel = Channels.newChannel(out);
			sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
			out.flush();
			raf.close();
		}
	}
	
	
}
