package org.ysh.servlet.tools;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadTools {
	
	private Map<String,List<String>> params = new HashMap<String,List<String>>();
	
	private Map<String,FileItem> files = new HashMap<String,FileItem>();
	
	private HttpServletRequest request;
	
	private List<FileItem> items = null;
	
	private int maxSize = 3145728;
	
	public FileUploadTools(HttpServletRequest request,int maxSize,String tempDir)
	{
		this.request = request;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		if(null!=tempDir)
		{
			factory.setRepository(new File(tempDir));
		}
		ServletFileUpload upload = new ServletFileUpload(factory);
		if(maxSize > 0){
			this.maxSize = maxSize;
		}
		upload.setFileSizeMax(this.maxSize);
		try{
			this.items = upload.parseRequest(this.request);
		}catch(FileUploadException e){
			e.printStackTrace();
		}
		this.init();
	}
	
	private void init(){
		Iterator<FileItem> iter = this.items.iterator();
		while(iter.hasNext()){
			FileItem item = iter.next();
			//表单元素
			if(item.isFormField()){
				String name = item.getFieldName();
				String value = item.getString();
				List<String> tmp = null;
				if(this.params.containsKey(name)){
					tmp = this.params.get(name);
				}else{
					tmp = new ArrayList<String>();
					this.params.put(name, tmp);
				}
				tmp.add(value);
			}
			else
			{
				//文件
				String fileName=java.util.UUID.randomUUID().toString()+ FileTools.getSuffix(item.getName());
				this.files.put(fileName, item);
			}
		}
	}
	
	/**
	 * 获取表单中的参数
	 * @param name
	 * @return
	 */
	public String getParameter(String name){
		String val = null;
		List<String> tmp = params.get(name);
		if(null != tmp && tmp.size() > 0){
			try {
				val = new String(tmp.get(0).getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return val;
	}
	
	/**
	 * 获取表单中的复合参数
	 * @param name
	 * @return
	 */
	public String[] getParameterValues(String name){
		String[] vals = null;
		List<String> tmp = params.get(name);
		if(null != tmp && tmp.size() > 0){
			vals = tmp.toArray(new String[]{});
		}
		return vals;
	}
	
	/**
	 * 获取表单上传的所有文件项
	 * @return
	 */
	public Map<String,FileItem> getUploadFiles(){
		return this.files;
	}
	
	/**
	 * 保存所有上传的文件
	 * @param saveDir
	 * @return
	 * @throws Exception
	 */
	public List<String> saveAll(String saveDir) throws Exception{
		List<String> fileNames = new ArrayList<String>();
		if(this.files.size() > 0)
		{
			Set<String> keys = this.files.keySet();
			Iterator<String> iter = keys.iterator();
			while(iter.hasNext())
			{
				String dest = iter.next();
				FileItem item = this.files.get(dest);
				FileTools.writeFile(item.getInputStream(), new File(saveDir+dest));
				fileNames.add(dest);
			}
		}
		return fileNames;
	}
}
