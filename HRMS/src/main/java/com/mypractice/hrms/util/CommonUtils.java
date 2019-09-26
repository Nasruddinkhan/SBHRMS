package com.mypractice.hrms.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

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
	public static final String KEY = "Hrms12345JSOFT12345";
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
}
