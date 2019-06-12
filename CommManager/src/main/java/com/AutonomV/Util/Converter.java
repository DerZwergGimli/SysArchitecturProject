package com.AutonomV.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Converter {


    public static String pojo2json(Object T) {
        ObjectMapper mapper = new ObjectMapper();
        String S = null;
        try {
            S = mapper.writeValueAsString(T);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return S;
    }

    public static Object json2pojo(String mString, Object T) {

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Create an Instance from the corresponding Class
        try {
            T = T.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // Map the object and store the data in its attributes accordingly
        try {
            T = objectMapper.readValue(mString.getBytes(), T.getClass());
            System.out.println("Converted Object from Class " + T.getClass().getName() + ":" + T);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return T;
    }
}
