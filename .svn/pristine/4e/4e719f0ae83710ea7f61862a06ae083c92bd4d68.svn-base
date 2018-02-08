package com.cjzf.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * @ClassName JwtUtils
 * @Description
 * @author nicholas
 * @Date 2018年1月11日 上午12:21:34
 * @version 1.0.1
 */
@Slf4j
public class MD5Utils {
    private static final Logger log = LoggerFactory.getLogger(MD5Utils.class);
    
    private MD5Utils() {
    }

    /**
     * 获取MD5值
     *
     * @param inStr 要加密的字符串
     * @return MD5值
     */
    public static String getMD5(String inStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            log.error("exception message is: {}", ExceptionUtils.getStackTrace(e));
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuilder hexValue = new StringBuilder();

        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }
}