package com.physics.quesbank.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
	public static void main(String[] args) {
		// 测试从图片文件转换为Base64编码
		System.out.println(GetImageStr("f:/1-card.jpg"));
		// 测试从Base64编码转换为图片文件
//		String strImg = "这里放64位编码";
//		GenerateImage(strImg, "C:/Users/zhangcx/Pictures/ash_1.jpg");

	}
	
//	public static String getBase64(String path) {
//		String base64 = null;
//		InputStream is = null;
//		try {
//			is = new FileInputStream(path);
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			base64 = Base64.encodeBase64String(data);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return "";
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return base64;
//	}

	public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static byte[] GenerateImageToByte(String imgStr) {
		// 对字节数组字符串进行Base64解码
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			return bytes;
		} catch (Exception e) {
			return null;
		}
	}
}