package com.landy.ssm.domain;

import java.util.List;

/**
 * @author landyl
 * @create 5:18 PM 07/17/2018
 */
public class Student {

    private String firstName;
    private String lastName;
    private Integer gender;
    private List<String> foods;
    private String quote;
    private String education;
    private String tOfD;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public List<String> getFoods() {
        return foods;
    }

    public void setFoods(List<String> foods) {
        this.foods = foods;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String gettOfD() {
        return tOfD;
    }

    public void settOfD(String tOfD) {
        this.tOfD = tOfD;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", foods=" + foods +
                ", quote='" + quote + '\'' +
                ", education='" + education + '\'' +
                ", tOfD='" + tOfD + '\'' +
                '}';
    }

}
