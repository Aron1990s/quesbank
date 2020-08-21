package com.physics.quesbank.util;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * 保留小数util
 * @author aron
 *
 */
public class NumberFormatUtil {

	/*
	 * 保留一位小数
	 */
	public static String numberFormatForOneDecimal(float f){
		NumberFormat nf = NumberFormat.getInstance();
        nf.setRoundingMode(RoundingMode.HALF_UP);//设置四舍五入
        nf.setMinimumFractionDigits(1);//设置最小保留几位小数
        nf.setMaximumFractionDigits(1);//设置最大保留几位小数
        return nf.format(f);
	}
	
	/*
	 * 保留一位小数
	 */
	public static String numberFormatForOneDecimal(double f){
		NumberFormat nf = NumberFormat.getInstance();
        nf.setRoundingMode(RoundingMode.HALF_UP);//设置四舍五入
        nf.setMinimumFractionDigits(1);//设置最小保留几位小数
        nf.setMaximumFractionDigits(1);//设置最大保留几位小数
        return nf.format(f);
	}
	
	/*
	 * 保留0位小数
	 */
	public static String numberFormatForTwoDecimal(float f){
		NumberFormat nf = NumberFormat.getInstance();
        nf.setRoundingMode(RoundingMode.HALF_UP);//设置四舍五入
        nf.setMinimumFractionDigits(0);//设置最小保留几位小数
        nf.setMaximumFractionDigits(0);//设置最大保留几位小数
        return nf.format(f);
	}
	
	/*
	 * 保留0位小数
	 */
	public static int numberFormatForTwoDecimal(double f){
		NumberFormat nf = NumberFormat.getInstance();
        nf.setRoundingMode(RoundingMode.HALF_UP);//设置四舍五入
        nf.setMinimumFractionDigits(0);//设置最小保留几位小数
        nf.setMaximumFractionDigits(0);//设置最大保留几位小数
        return Double.valueOf(new java.text.DecimalFormat("#.00").format(f)).intValue();
	}
	
	public static void main(String[] args) {
		System.out.println(numberFormatForTwoDecimal(12.51));
	}

}
