package com.landy.ssm.domain;

/**
 * @author landyl
 * @create 10:04 AM 07/17/2018
 */
public class Person {

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //@NotBlank(message = "人名不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Person {" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

}
