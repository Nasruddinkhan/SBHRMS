/**
 * nasru
 * Test.java
 * Jan 13, 2020
 */
package com.mypractice.hrms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\F\\Documents\\Proteus Documents\\Appoiment-letter-proteus.PDF");
		System.out.println(file.exists());
		byte[] bytecontent =  FileUtils.readFileToByteArray(file);
		String byteArray =Base64.getEncoder().encodeToString(bytecontent);
		System.out.println(byteArray);

	    try ( FileOutputStream fos = new FileOutputStream( new File("D:\\Application_Logs\\files\\69_test.pdf")); ) {
	      byte[] decoder = Base64.getDecoder().decode(byteArray);

	      fos.write(decoder);
	      System.out.println("PDF File Saved");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}

}