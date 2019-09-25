package com.yc.util;

/**
 * @author wk
 * @date 2019/9/22  16:31
 */
public class StringIsNull {

    public static boolean isNull(String...strings){

        if (strings == null || strings.length<=0 ) {
            return true;
        }

        for (String string : strings) {
            if (string == null || "".equals(string)) {
                return true;
            }
        }
        return false;
    }
}
