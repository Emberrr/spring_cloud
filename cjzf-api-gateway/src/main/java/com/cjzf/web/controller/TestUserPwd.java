/******************************************************************
*
*    Java Lib , Powered By beijing nicholas.
*
*    Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
*
*    Package:     com.cjzf.web.controller
*
*    Filename:    TestUserPwd.java
*
*    Description: TODO(用一句话描述该文件做什么)
*
*    Copyright:   Copyright (c) 2001-2017
*
*    Company:     nicholas Co.,Ltd
*
*    @author:     lipengpeng
*
*    @version:    1.0.1
*
*    Create at:   2018年1月17日 下午4:58:33
*
*    Revision:
*
*    2018年1月17日 下午4:58:33
*        - first revision
*
*****************************************************************/

package com.cjzf.web.controller;

import com.cjzf.util.MD5Utils;

/**
* @ClassName TestUserPwd
* @Description TODO(这里用一句话描述这个类的作用)
* @author lipengpeng
* @Date 2018年1月17日 下午4:58:33
* @version 1.0.1
*/
public class TestUserPwd {
    public static void main(String[] args){
        String pwd = "lpp";
        String salt = "123456";
        String md5Password = MD5Utils.getMD5(pwd + salt);
        //nicholas String depwd = "785ab7f70b5d13b6b82830ee4fa00225";
        System.out.println("Username:nicholas--Password:"+md5Password);
    }
}
