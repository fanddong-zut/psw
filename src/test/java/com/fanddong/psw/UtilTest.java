package com.fanddong.psw;

import com.fanddong.psw.util.Base64Util;
import com.fanddong.psw.util.QuickSDKDesUtil;

public class UtilTest {

    public static void main(String[] args) {
        String str = "fdd19930816";
        String encode = Base64Util.encodeData(str);

        System.out.println(encode);

        String decode = Base64Util.decodeData(encode);
        System.out.println(decode);

        String s1 = QuickSDKDesUtil.encode(str,"hello");
        System.out.println(s1);
        String s2 = QuickSDKDesUtil.decode(s1,"hello");
        System.out.println(s2);

    }
}
