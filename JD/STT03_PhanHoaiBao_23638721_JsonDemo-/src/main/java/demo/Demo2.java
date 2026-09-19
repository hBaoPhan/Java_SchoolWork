package demo;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.StringReader;

public class Demo2 {
    public static void main(String[] args) {
        String address="{\"street\":\"12 Nguyen Van Bao\",\"ward\":\"Hanh Thong\",\"city\":\"HCM\"}";

        try(JsonReader reader = Json.createReader(new StringReader(address))){
           JsonObject jo=reader.readObject();
            System.out.println(jo.getString("city"));
            System.out.println(jo.getString("ward"));
            System.out.println(jo.getString("street"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
