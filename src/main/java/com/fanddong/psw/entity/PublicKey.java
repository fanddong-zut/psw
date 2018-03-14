package com.fanddong.psw.entity;

/**
 * 加密公钥
 */
public class PublicKey {

    //存储密码加密公钥
    private static final String PSW_KEY = "Christmas";

    public static String getPswKey() {
        return PSW_KEY;
    }
}
