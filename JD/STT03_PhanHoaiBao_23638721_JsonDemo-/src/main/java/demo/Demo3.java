package demo;

import jakarta.json.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo3 {
    public static void main(String[] args) {
        try(JsonReader jsonReader= Json.createReader(new FileReader("json/student.json"))){
            JsonArray jsonArray=jsonReader.readArray();
            for(JsonValue jv: jsonArray){
                if(jv instanceof JsonObject){
                    JsonObject jo=(JsonObject) jv;
                    System.out.println("First name: "+jo.getString("first_name"));
                    System.out.println("Age: "+jo.getInt("age"));
                }
            }

        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
