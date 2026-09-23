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
//    public static Person toPerson(String filename) {
//        Person person=null;
//        try(JsonReader reader= Json.createReader(new FileReader(filename))){
//            JsonObject jo=reader.readObject();
//            if(jo!=null){
//                person =new Person();
//                person.setFirstName(jo.getString("firstName"));
//                person.setLastName(jo.getString("lastName"));
//                person.setAge(jo.getInt("age"));
//                person.setAddress(new Address());
//                person.getAddress().setStreetAddress(jo.getJsonObject("address").getString("streetAddress"));
//                person.getAddress().setCity(jo.getJsonObject("address").getString("city"));
//                person.getAddress().setState(jo.getJsonObject("address").getString("state"));
//                person.getAddress().setPostalCode(jo.getJsonObject("address").getInt("postalCode"));
//
//                List<PhoneNumber> phoneNumberList=new ArrayList<>();
//                for (JsonObject pn : jo.getJsonArray("phoneNumbers").getValuesAs(JsonObject.class)) {
//                    PhoneNumber phoneNumber=new PhoneNumber();
//                    phoneNumber.setNumber(pn.getString("number"));
//                    phoneNumber.setType(pn.getString("type"));
//                    phoneNumberList.add(phoneNumber);
//                }
//                person.setPhoneNumbers(phoneNumberList);
//
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return person;
//
//    }
    public static Person toPerson(String filename) throws FileNotFoundException {
        JsonReader jsonReader=Json.createReader(new FileReader(filename));
        JsonObject jsonObject=jsonReader.readObject();
        Person person=new Person();
        person.setFirstName(jsonObject.getString("firstName"));
        person.setLastName(jsonObject.getString("lastName"));
        person.setAge(jsonObject.getInt("age"));

        JsonObject addObject=jsonObject.getJsonObject("address");
        Address address=new Address(addObject.getString("streetAddress"),
        addObject.getString("city"),
                addObject.getString("state"),
                addObject.getInt("postalCode")
        );
        person.setAddress(address);
        List<PhoneNumber> phoneNumberList=jsonObject.getJsonArray("phoneNumbers")
                .getValuesAs(JsonObject.class)
                .stream()
                .map(obj-> new PhoneNumber(obj.getString("type"),
                        obj.getString("number"))).collect(Collectors.toList());

        person.setPhoneNumbers(phoneNumberList);
        return person;
    }


    public static Address parseAddress(JsonObject jsonObject){
        return new Address(jsonObject.getString("streetAddress"),
                jsonObject.getString("city"),
                jsonObject.getString("state"),
                jsonObject.getInt("postalCode"));
    }
    public static PhoneNumber parsePhoneNumber(JsonObject jsonObject){
        return  new PhoneNumber(jsonObject.getString("type"),jsonObject.getString("number"));
    }




    public static List<Person> toPersonList(String filename){
            try(JsonReader jsonReader=Json.createReader(new FileReader(filename))){
                JsonArray jsonArray=jsonReader.readArray();

                return jsonArray.getValuesAs(JsonObject.class)
                        .stream()
                        .map(obj->
                                new Person(obj.getString("firstName"),
                                 obj.getString("lastName"),obj.getInt("age"),
                                parseAddress(obj.getJsonObject("address")) ,
                                obj.getJsonArray("phoneNumbers").
                                        getValuesAs(JsonObject.class).
                                        stream().
                                        map(JsonUtil::parsePhoneNumber).
                                        collect(Collectors.toList()))).collect(Collectors.toList());
            } catch (Exception e) {

                return null;
            }
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

                         else if(person.getFirstName().equals(firstName)){
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
    public static List<State> findStateNameStartWith(String stateName){

        String keyName="";
        State state=null;
        List<State> stateList=null;
        try(JsonParser jsonParser=Json.createParser(new FileReader("json/state.json"))){
            while (jsonParser.hasNext()){
                JsonParser.Event event=jsonParser.next();
                switch (event){
                    case START_OBJECT -> {
                        state=new State();
                    }
                    case START_ARRAY -> {
                        stateList=new ArrayList<>();
                    }
                    case KEY_NAME -> {
                        keyName=jsonParser.getString();
                    }
                    case VALUE_STRING -> {
                        if(keyName.equals("StateName")){
                            state.setStateName(jsonParser.getString());
                        } else if (keyName.equals("Abbreviation")) {
                            state.setAbbreviation(jsonParser.getString());

                        } else if (keyName.equals("Capital")) {
                            state.setCapital(jsonParser.getString());
                        }
                    }
                    case VALUE_NUMBER -> {
                        if(keyName.equals("Statehood")){
                            state.setStatehood(jsonParser.getInt());
                        } else if (keyName.equals("ID")) {
                            state.setID(jsonParser.getInt());
                        }
                    }
                    case END_ARRAY -> {

                    }
                    case END_OBJECT -> {
                        if(state.getStateName().contains(stateName)){
                            stateList.add(state);
                        }

                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return stateList;
    }
}
