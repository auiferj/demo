package com.example.jdk8.util;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Random;

public class StringUtil {
    /**
     * 随机字符串的来源字符串，默认为小写字母和数字
     */
    public static final String BASE = "abcdefghijklmnopqrstuvwxyz0123456789";
    /**
     * 随机字符串的来源字符串，大写字母
     */
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 随机字符串的来源字符串，小写字母
     */
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    /**
     * 随机字符串的来源字符串，数字
     */
    public static final String NUMBER = "0123456789";
    /**
     * 随机字符串的来源字符串，大写字母和数字
     */
    public static final String UPPERCASE_NUMBER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * 随机字符串的来源字符串，大写字母、小写字母和数字
     */
    public static final String UPPERCASE_LOWERCASE_NUMBER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 获取随机位数的字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(BASE.length());
            sb.append(BASE.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机位数的字符串
     *
     * @param length 随机字符串的位数
     * @param base   随机字符串的来源字符串
     * @return
     */
    public static String getRandomString(int length, String base) {
        if (StringUtils.hasLength(base)) {
            base = BASE;
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 判断是否是windows操作系统
     */
    public static Boolean isWinOs() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取临时目录
     *
     */
    public static String getTempPath() {
        ///return System.getProperty("java.io.tmpdir");
        String str = System.getProperty("user.dir");
        str = str.substring(0,str.indexOf(":")+2);
        str = str+"temp";
        return str;
    }

    /**
     * 获取项目路径
     */
    public static String getWebRootPath(String filePath) {
        try {
            String path = StringUtil.class.getClassLoader().getResource("").toURI().getPath();
            path = path.replace("/WEB-INF/classes/", "");
            path = path.replace("/target/classes/", "");
            path = path.replace("file:/", "");
            if (StringUtils.hasLength(filePath)) {
                return path;
            } else {
                return path + "/" + filePath;
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文件后缀名 不包含点
     */
    public static String getFileSuffix(String fileWholeName) {
        if (!StringUtils.hasLength(fileWholeName)) {
            return "none";
        }
        int lastIndexOf = fileWholeName.lastIndexOf(".");
        return fileWholeName.substring(lastIndexOf + 1);
    }

    /**
     * 去除小数点后面多余的0
     *
     * @param s
     * @return
     */
    public static String rvZeroAndDot(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");// 去掉多余的0
            s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
        }
        return s;
    }
}
