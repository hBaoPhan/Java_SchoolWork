import entity.Person;
import entity.PhoneNumber;
import entity.State;
import jsonUtil.JsonUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        java.util.List<State> phoneNumberList =JsonUtil.toState("json/state.json");
//        System.out.println(phoneNumberList);

        Person person=JsonUtil.findByFirstName("Jon");
        System.out.println(person);


    }
}
