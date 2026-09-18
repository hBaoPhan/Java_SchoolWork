package jsonUtil;

import entity.Address;
import entity.Person;
import entity.PhoneNumber;
import entity.State;
import jakarta.json.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonUtil {
    public static Person toPerson(String filename) {
        Person person=null;
        try(JsonReader reader= Json.createReader(new FileReader(filename))){
            JsonObject jo=reader.readObject();
            if(jo!=null){
                person =new Person();
                person.setFirstName(jo.getString("firstName"));
                person.setLastName(jo.getString("lastName"));
                person.setAge(jo.getInt("age"));
                person.setAddress(new Address());
                person.getAddress().setStreetAddress(jo.getJsonObject("address").getString("streetAddress"));
                person.getAddress().setCity(jo.getJsonObject("address").getString("city"));
                person.getAddress().setState(jo.getJsonObject("address").getString("state"));
                person.getAddress().setPostalCode(jo.getJsonObject("address").getInt("postalCode"));

                List<PhoneNumber> phoneNumberList=new ArrayList<>();
                for (JsonObject pn : jo.getJsonArray("phoneNumbers").getValuesAs(JsonObject.class)) {
                    PhoneNumber phoneNumber=new PhoneNumber();
                    phoneNumber.setNumber(pn.getString("number"));
                    phoneNumber.setType(pn.getString("type"));
                    phoneNumberList.add(phoneNumber);
                }
                person.setPhoneNumbers(phoneNumberList);


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;

    }
    public static List<State> toState(String filename){

        try(JsonReader reader= Json.createReader(new FileReader(filename))){
            JsonArray jsonArray=reader.readArray();
            return jsonArray.getValuesAs(JsonObject.class)
                    .stream()
                    .map(obj -> new State(obj.getString("StateName"),
                            obj.getString("Abbreviation"),
                            obj.getString("Capital"),
                            obj.getInt("Statehood"),
                            obj.getInt("ID") )).collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
                return null;
        }
    }
}
