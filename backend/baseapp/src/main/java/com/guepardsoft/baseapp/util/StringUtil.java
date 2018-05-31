package com.guepardsoft.baseapp.util;

public class StringUtil {

    public static boolean isNullOrEmpty(String value) {
        System.out.println("String.isNullOrEmpty - value: "+ value);
        boolean response = true;
        if(value != null && !value.trim().isEmpty())
            response = false;
        System.out.println("String.isNullOrEmpty - response: "+ response);
        return response;
    }
}
