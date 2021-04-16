package com.chomolungma.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest extends ClassLoader{
	private String classLoaderName;
	private final String fileExtension=".class";
	
	
	
	public MyTest(String classLoaderName) {
		super();
		this.classLoaderName = classLoaderName;
	}
	
	public MyTest(ClassLoader parent, String classLoaderName) {
		super(parent);
		this.classLoaderName = classLoaderName;
	}
	
	
	@Override
	public String toString() {
		return "["+this.classLoaderName+"]";
	}
	
	
	private byte[] loadClassData(String name) {
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;
		
		try {
			this.classLoaderName = this.classLoaderName.replace(".", "\\");
			
			
			is = new FileInputStream(new File(name + this.fileExtension));
			baos = new ByteArrayOutputStream();
			
			int ch = 0;
			while(-1 != (ch = is.read())) {
				baos.write(ch);
			}
			
			
			data = baos.toByteArray();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				is.close();
				baos.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return data;
		
	}
	
}
