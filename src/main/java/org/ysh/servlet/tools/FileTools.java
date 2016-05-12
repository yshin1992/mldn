package org.ysh.servlet.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * 文件操作工具类
 * @author Administrator
 *
 */
public class FileTools {
	
	public static String getSuffix(String fileName)
	{
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		return null == suffix? "" : suffix;
	}
	
	public static void writeFile(File source,File dest) throws IOException
	{
		writeFile(source,dest,false);
	}
	
	public static void writeFile(File source,File dest,Boolean createDestFile) throws IOException
	{
		if(null != source && null != dest){
			if(null != createDestFile && createDestFile == true){
				if(!dest.exists()){
					dest.createNewFile();
				}
			}else
			{
				if(!dest.exists()){
					throw new FileNotFoundException("目的文件不能为空!");
				}
			}
			
			RandomAccessFile sourceRAF = new RandomAccessFile(source, "r");
			RandomAccessFile destRAF = new RandomAccessFile(dest, "rw");
			
			FileChannel sourceChannel = sourceRAF.getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destRAF.getChannel());
			
			destRAF.close();
			sourceRAF.close();
		}
	}
	
	public static void writeFile(String source,String dest) throws IOException
	{
		if(null != source && null != dest)
		{
			writeFile(new File(source),new File(dest));
		}
	}
	
	public static void writeFile(InputStream input,File outputFile) throws IOException
	{
		if(null != input && null != outputFile){
			ReadableByteChannel read = Channels.newChannel(input);
			RandomAccessFile write = new RandomAccessFile(outputFile, "rw");
			
			FileChannel outChannel = write.getChannel();
			outChannel.transferFrom(read, 0, input.available());
			
			outChannel.close();
			write.close();
		}
	}
}
