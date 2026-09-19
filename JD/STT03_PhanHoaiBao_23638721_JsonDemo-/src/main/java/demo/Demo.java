package demo;

import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        JsonObjectBuilder builder= Json.createObjectBuilder()
                .add("first_name","Bao")
                .add("last_name","Liu")
                .add("age",99)
                .add("phones",Json.createArrayBuilder()
                        .add("0335335335")
                        .add("0335335336")).
                add("address",Json.createObjectBuilder()
                        .add("street","12 Nguyen Van Bao")
                        .add("ward","Hanh Thong")
                                .add("city","Ho Chi Minh")
                        );
        JsonObject jsonObject= builder.build();
        System.out.println(jsonObject);
        write2file(jsonObject,"json/student.json");



    }
    public static void write2file(JsonObject jsonObject,String path){
        Map<String,Object> cfg=new HashMap<String,Object>();
        cfg.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory writerFactory = Json.createWriterFactory(cfg);
        try (JsonWriter writer=writerFactory.createWriter(Files.newBufferedWriter(Path.of(path)))){
            writer.write(jsonObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
