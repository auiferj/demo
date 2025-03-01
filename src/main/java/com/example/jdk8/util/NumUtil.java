package com.example.jdk8.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 数字格式化的类
 * https://www.jianshu.com/p/b9dd363e3ff8
 */
public class NumUtil {

	/**
	 * 数值格式化
	 * @Description 保留指定位数的小数(少位补零)
	 * @author fengshuonan
	 */
	public static String keepRandomPoint(Double value, int n) {
		if (value == null) {
			value = 0.00;
			return new BigDecimal(value).setScale(n, RoundingMode.HALF_UP).toString();
		} else {
			return new BigDecimal(value).setScale(n, RoundingMode.HALF_UP).toString();
		}
	}

	/**
	 * “0”——表示一位数值，如没有，显示0。如“0000.0000”，整数位>4，按实际输出，整数位<4前面补0。小数位>4四射五位保留四位。小数位<4后面补0，凑足4位。
	 * “#”——表示任意位数的整数。如没有，则不显示。在小数点位使用，只表示一位小数，超出部分四舍五入。如：
	 * “#”：无小数，小数部分四舍五入。
	 * “.#”：整数部分不变，一位小数，四舍五入。
	 * “.##”：整数部分不变，二位小数，四舍五入。
	 * “.”——表示小数点。
	 * “，”——与模式“0”一起使用，表示逗号。
	 *
	 *
	 * @Description 浮点保留两位小数(少位补零)
	 * @author fengshuonan
	 */
	public static String keepZero(double value) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(value);
	}

	/**
	 * 浮点保留两位小数(少位不补零)
	 * @param value
	 * @return
	 */
	public static String keep(double value) {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(value);
	}

	/**
	 * 百分比格式化
	 * @Description 获取任意小数点位的百分比表示(少位不补零)
	 * @author fengshuonan
	 */
	public static String percent(double value, int n) {
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setGroupingUsed(false);//不加逗号(默认是有逗号的)
		percent.setMaximumFractionDigits(n);//最大小数位数n，不够n位也不补零
		return percent.format(value);
	}

	/**
	 * 百分比格式化
	 * 设置百分数精确度2即保留两位小数(少位补零)
	 * @param percent
	 * @return
	 */
	public static String percentZero(Double percent,int scale) {
		NumberFormat nt = NumberFormat.getPercentInstance();
		nt.setGroupingUsed(false);//不加逗号(默认是有逗号的)
		nt.setMinimumFractionDigits(scale);//最小数位数n,不够则补零
		return nt.format(percent);
	}

	/**
	 * 货币格式化
	 * @param value
	 * @return
	 */
	public static String currencyFormat(double value) {
		//按系统预设的货币格式输出，这里是人民币
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(value);
	}

}
