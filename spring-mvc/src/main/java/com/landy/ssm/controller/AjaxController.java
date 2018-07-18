package com.landy.ssm.controller;

import com.landy.ssm.domain.Person;
import com.landy.ssm.domain.Student;
import com.landy.ssm.utils.JsonUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 前台使用 serializeObject()序列化后的值，通过SpringMVC自身进行处理
     * 请求参数存放在 [Request Payload] 中
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping("/testStudent")
    public Student testStudent(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

    /**
     * 前台使用 serializeObject()序列化后的值，引入第三方 Jar 包进行处理。
     * 请求参数存放在 [Request Payload] 中
     * @param inputBody
     * @return
     */
    @ResponseBody
    @RequestMapping("/testStudentThirdParty")
    public Student testStudentThirdParty(@RequestBody String inputBody) {
        Student student = JsonUtil.fromJson(inputBody, Student.class);
        System.out.println(student);
        return student;//"success";
    }

    /**
     * 请求参数存放在 Form Data 中。
     * 不需要指定@RequestBody，并且consumes也不用指定
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/testStudentSerialize")
    public Student testStudentSerialize(Student student) {
        System.out.println(student);
        return student;//"success";
    }

    @RequestMapping("/testJsonListWithAjaxFormSerializePage")
    public String testJsonListWithAjaxFormSerializePage() {
        return "testJsonListWithAjaxFormSerializePage";
    }

    @RequestMapping("/complexDataPage")
    public String complexDataPage() {
        return "complexDataPage";
    }

    /**
     * 后端处理：使用第三方工具类进行解析
     * 请求参数存放在 Form Data 中。
     * @param studentStr
     * @param amount
     * @return
     */
    @RequestMapping("/testStudentWithComplexData")
    public String testStudentWithComplexData(@RequestParam("student") String studentStr, String amount) {
        Student student = JsonUtil.fromJson(studentStr, Student.class);
        System.out.println("student:" + student);
        System.out.println("amount：" + amount);
        return "success";
    }

    @RequestMapping("/complexDataWithSerializePage")
    public String complexDataWithSerializePage() {
        return "complexDataWithSerializePage";
    }

    /**
     * 直接让SpringMVC 来解析，请求无法到达
     * 出现500错误
     * @param student
     * @param amount
     * @return
     */
//    @RequestMapping("/testStudentWithComplexDataSerialize")
//    public String testStudentWithComplexDataSerialize(@RequestParam("student") Student student, String amount) {
//        System.out.println("student:" + student);
//        System.out.println("amount：" + amount);
//        return "success";
//    }

    /**
     * 把@RequestParam注解去除，请求可以正常到达目标 Handler方法,无法映射student对象.
     * 解决方案：自己解析，编写自定义的类型转换器
     * @param student
     * @param amount
     * @return
     */
    @RequestMapping("/testStudentWithComplexDataSerialize")
    public String testStudentWithComplexDataSerialize(Student student, String amount) {
        System.out.println("student:" + student);
        System.out.println("amount：" + amount);
        return "success";
    }

}
