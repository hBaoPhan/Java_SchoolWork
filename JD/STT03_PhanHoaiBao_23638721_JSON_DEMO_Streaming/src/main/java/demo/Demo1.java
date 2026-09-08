package demo;

import JsonUtil.JsonUtil;
import entity.Address;
import entity.Student;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Student student = new Student(100,"Bao","Phan",20);
      // student.setPhones(List.of("0335335335","225225252"));
        student.setAddress(new Address("12 NVB","Hanh thong","HCM"));
        System.out.println(student);

        JsonUtil.toJson(student,"json/student.json");
    }
}
