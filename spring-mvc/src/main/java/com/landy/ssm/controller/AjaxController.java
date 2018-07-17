package com.landy.ssm.controller;

import com.landy.ssm.domain.Person;
import com.landy.ssm.domain.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author landyl
 * @create 9:47 AM 07/17/2018
 */
@Controller
public class AjaxController {

    //对于简单的一个Person 对象来说，我们甚至都不需要借助于 JSON 就可以完成请求的数据与实体之间的映射。
    @ResponseBody
    @RequestMapping(path = "/testJson",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    public Person testJson(Person person) {
        System.out.println("person:" + person);
        if(person != null) {
            person.setName("ajax-" + person.getName());
        }
        return person;
    }

    //对于Person数组来说，需要发送什么样的格式才能被 SpringMVC 直接处理？
    //（1）需要指定 "contentType"，同时需要注意的是：发送的请求数据不在 Form data 中，而是在 Request Payload 中。关于 [Request Payload] ，在后面说明。
    //（2）必须要指定 @RequestBody ，否则无法解析。
    @ResponseBody
    @RequestMapping(path = "/testJsonList",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Person> testJsonList(@RequestBody List<Person> persons) {
        System.out.println("persons:" + persons);
        return persons;//"success";
    }

    @ResponseBody
    @RequestMapping("/testJsonListWithNonForm")
    public String testJsonListWithNonForm(@RequestBody List<Person> persons) {
        System.out.println(persons);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/testStudent")
    public Student testStudent(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

}
