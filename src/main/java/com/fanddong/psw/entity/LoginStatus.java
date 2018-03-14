package com.fanddong.psw.entity;

import sun.rmi.runtime.Log;

/**
 * 用于记录用户登录信息
 */
public class LoginStatus {
    private static final String USRNAME = "9728";
    private static final String PWD = "q1w2e3";
    private int  status;//在线状态 1：在线  0：不在线

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 判断用户名密码
     * @param usrname
     * @param pwd
     * @return
     */
    public static boolean identity(String usrname, String pwd) {
        boolean flag = usrname.equals(USRNAME) && pwd.equals(PWD);
        return flag;
    }

    private static LoginStatus loginStatus = null;

    /**
     * 获取单例模式
     * @return
     */
    public static LoginStatus getInstance() {
        if(loginStatus == null) {
            synchronized (LoginStatus.class) {
                if(loginStatus == null)
                    loginStatus = new LoginStatus();
                return loginStatus;
            }
        }
        return loginStatus;
    }
}
