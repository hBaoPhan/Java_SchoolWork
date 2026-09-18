package jsonUtil;

import entity.Address;
import entity.Person;
import entity.PhoneNumber;
import entity.State;
import jakarta.json.*;
import jakarta.json.stream.JsonParser;

import java.io.FileNotFoundException;
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

    public static Person findByFirstName(String firstName){
        Person person=null;
        String keyName="";
        Address address=null;
        List<PhoneNumber> phoneNumbers=null;
        PhoneNumber phoneNumber=null;
        try(JsonParser parser=Json.createParser(new FileReader("json/person.json"))){
            while (parser.hasNext()){
                JsonParser.Event event=parser.next();
                switch (event){
                    case START_ARRAY ->{
                        if(keyName.equals("phoneNumbers")){
                            phoneNumbers=new ArrayList<>();
                        }


                    }
                    case START_OBJECT -> {
                        if(person==null){
                            person=new Person();
//                        person.setAddress(new Address());
                        } else if (keyName.equals("address")) {
                            address=new Address();
                        } else if (phoneNumbers!=null && phoneNumber==null) {
                            phoneNumber=new PhoneNumber();
                        }

                    }
                    case KEY_NAME -> {
                        keyName=parser.getString();
//                        System.out.println(keyName);
                    }
                    case VALUE_NUMBER -> {
                        if(keyName.equals("age")){

                            person.setAge(parser.getInt());
                        }

                    }
                    case VALUE_STRING -> {
                        if(keyName.equals("firstName")){
                            person.setFirstName(parser.getString());
                        }else if(keyName.equals("lastName")){
                            person.setLastName(parser.getString());
                        } else if (keyName.equals("streetAddress")) {
                            address.setStreetAddress(parser.getString());
                            
                        }else if(keyName.equals("city")){
                            address.setCity(parser.getString());
                        } else if (keyName.equals("state")) {
                            address.setState(parser.getString());
                        } else if (keyName.equals("postalCode")) {
                            address.setPostalCode(parser.getInt());
                        } else if (keyName.equals("type")) {
                            phoneNumber.setType(parser.getString());
                        } else if (keyName.equals("number")) {
                            phoneNumber.setNumber(parser.getString());
                        }

                    }
                    case END_ARRAY -> {
                        person.setPhoneNumbers(phoneNumbers);
                        phoneNumbers=null;

                    }
                    case END_OBJECT -> {
                        if(address!=null){
                            person.setAddress(address);

                        }
                        if (phoneNumber!=null){
                            phoneNumbers.add(phoneNumber);
                            phoneNumber=null;


                        }

                         if(person.getFirstName().equals(firstName)){
                            return person;
                        }


                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
