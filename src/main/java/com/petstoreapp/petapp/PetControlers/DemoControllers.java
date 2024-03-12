package com.petstoreapp.petapp.PetControlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


class Student{
    private String name;
    private int age;
    private float marks;


    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public float getMarks() {
        return marks;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMarks(float marks) {
        this.marks = marks;
    }   
    
}

//@RestConstroller is combining two annotation
//@Controller and @Responsbody

@RestController

// @Controller
public class DemoControllers {



    @RequestMapping("/message")
//This annotation will specify that the method 
    //is return the data which will be converted into
    //json and send as the response
// @ResponseBody
public String getMessage(){
    //We are  returning the String data
    //and not the name of the view/html file
    return "Hello World";
}

@RequestMapping("/marks")
// @ResponseBody
public double getMarks(){
    return 90.45;

}

@RequestMapping("/colors")
// @ResponseBody
public List<String> getColors(){
    List<String> colors = Arrays.asList("Red", "yellow","blues","blick");
    return colors;
}

@RequestMapping("/stud")
// @ResponseBody

//Here we are returning the object of the student class
//which will be serialized into JSON format and 
//then send as the response
public Student getStudent(){
    Student s = new Student();
    s.setName("Ram");
    s.setAge(23);
    s.setMarks(90.45f);
    return s;   
    
}

@RequestMapping("studs")
@ResponseBody
public List<Student> listOfStudents (){
    List<Student> students = new ArrayList<>();
    Student s1 = new Student();
    s1.setName("kaam");
    s1.setAge(23);
    s1.setMarks(80.45f);
    students.add(s1);

    Student s2 = new Student();
    s2.setName("aam");
    s2.setAge(22);
    s2.setMarks(34.56f);
    students.add(s2);

    Student s3 = new Student();
    s3.setName("aam");
    s2.setAge(22);
    s2.setMarks(34.56f);
    students.add(s2);

    return students;

}

    
}
