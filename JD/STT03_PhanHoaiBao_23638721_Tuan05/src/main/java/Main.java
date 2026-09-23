import entity.Person;
import entity.PhoneNumber;
import entity.State;
import jsonUtil.JsonUtil;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

//        java.util.List<State> phoneNumberList =JsonUtil.toState("json/state.json");
//        System.out.println(phoneNumberList);

//        Person person=JsonUtil.findByFirstName("Jon");
//        System.out.println(person);

//        List<Person> personList=JsonUtil.toPersonList("json/person.json");
//        System.out.println(personList);

//        System.out.println(JsonUtil.toPerson("json/person.json"));

          System.out.println(JsonUtil.findStateNameStartWith("Alab"));


    }
}
