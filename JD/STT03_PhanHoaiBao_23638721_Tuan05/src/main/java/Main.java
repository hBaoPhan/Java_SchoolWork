import entity.Person;
import jsonUtil.JsonUtil;

public class Main {
    public static void main(String[] args) {

        Person person=JsonUtil.toPerson("json/person.json");
        System.out.println(person);
    }
}
