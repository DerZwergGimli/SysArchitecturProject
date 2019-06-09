package com.AutonomV.Util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

    public static String pojo2json(Object T){
        ObjectMapper mapper = new ObjectMapper();

        String S = new String();
        return S;
    }

    public static Object json2pojo(String S){
        Object T = new Object();
        return T;
    }
}
