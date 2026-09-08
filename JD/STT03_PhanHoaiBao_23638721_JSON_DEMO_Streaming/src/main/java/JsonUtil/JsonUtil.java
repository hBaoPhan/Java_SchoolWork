package JsonUtil;

import entity.Student;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonGeneratorFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    public static void toJson(Student student,String path) {
        Map<String,Object> map = new HashMap<>();
        map.put(JsonGenerator.PRETTY_PRINTING,true);
        JsonGeneratorFactory factory = Json.createGeneratorFactory(map);

        try(JsonGenerator gen= factory.createGenerator(new FileWriter(path))){
            gen.writeStartObject()
                    .write("id",student.getId())
                    .write("first_name",student.getFirstName())
                    .write("last_name",student.getLastName())
                    .write("age",student.getAge());

            if(student.getPhones()!=null) {
                gen.writeStartArray("phones");
                for (String phone : student.getPhones()) {
                    gen.write(phone);
                }
                gen.writeEnd();
            }
            if(student.getAddress()!=null) {
                gen.writeStartObject("address")
                        .write("street",student.getAddress().getStreet())
                        .write("ward",student.getAddress().getWard())
                        .write("city",student.getAddress().getCity())
                        .writeEnd();
            }


            gen.writeEnd();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
