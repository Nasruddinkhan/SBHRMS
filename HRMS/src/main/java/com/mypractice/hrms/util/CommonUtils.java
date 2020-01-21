package com.mypractice.hrms.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;

/**
 * Nasruddin khan
 * CommonUtils.java
 * Mar 11, 2019 6:51:44 PM
 */
public interface CommonUtils {
	public static final String VARCHAR_50 = "varchar(50)";
	public static final String VARCHAR_100 = "varchar(200)";
	public static final String DEFAULT = "int default 1";
	public static final String VARCHAR_10 = "varchar(10)";
	public static final String VARCHAR_30 = "varchar(30)";
	public static final String CHAR_01 = "char(1)";
	public static final String VARCHAR_15 = "varchar(15)";
	public static final String VARCHAR_12 = "varchar(15)";
	public static final String VARCHAR_20 =  "varchar(20)";
	public static final String CHAR_3 = "char(3)";
	public static final String VARCHAR_500 = "varchar(500)";
	public static final String JOB_TIME = "0 0/1 * 1/1 * ?";
	public static final String CHAR_01_DFLT = "char(1) default 'N' ";
	public static final String INIT_VECTOR = "RandomInitVector";
	public static final String KEY = "Nkhan";
	public static final String DIRECTORY="D:\\Application_Logs\\files";
	public static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(value.getBytes());
			return DatatypeConverter.printBase64Binary(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));
            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
	public static String writeFileOnDisk( String enCodeString, String fileName) {
		System.out.println(enCodeString);
		try ( FileOutputStream fos = new FileOutputStream( new File(DIRECTORY+"\\"+fileName)); ) {
			byte[] decoder = Base64.getDecoder().decode(enCodeString);
			fos.write(decoder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DIRECTORY;
	}

	/**
	 * @param string
	 * @return
	 */
	public static String readFileOnDisk(String fileName) {
		// TODO Auto-generated method stub
		String encodeFile = "";
		try {
			System.out.println(DIRECTORY+"\\"+fileName);
			encodeFile = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray( new File(DIRECTORY+"\\"+fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			encodeFile="file is mising please delete this and re upload";
		}
		return encodeFile;
	}

	public static String readAndEncodeFile(String fileName) {
		// TODO Auto-generated method stub
		String encodeFile = "";
		try {
			encodeFile = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray( new File(fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			encodeFile="file is mising please delete this and re upload";
		}
		return encodeFile;
	}
	/**
	 * @param string
	 */
	public static void deleFileOnDisk(String fileName) {
		// TODO Auto-generated method stub
		 File file= new File(DIRECTORY+"\\"+fileName);
		 if(!file.exists())
			 throw new RuntimeException("File is not present");
		 file.delete();
	}
	
	public static boolean checkFileOnDisk(String checkfile) {
		// TODO Auto-generated method stub
		 return new File(DIRECTORY+"\\"+checkfile).exists();
	}
	public static void main(String[] args) {
		System.out.println(CommonUtils.encrypt(CommonUtils.KEY, CommonUtils.INIT_VECTOR, "password"));
	}


}
