package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {

    public static <T> T toModel(BufferedReader reader, Class<T> clazz){
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return new ObjectMapper().readValue(sb.toString(),clazz);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    public static String toJson(Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return "";
    }

}
