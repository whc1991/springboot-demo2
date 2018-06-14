package com.cloud.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghc on 2018/6/11.
 */
@RestController
public class HelloController {
    @Value("${payment.notify-url}")
    public String url;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("spring boot demo 2 hello ");
        return "spring boot demo 2 url " + url;
    }

    @RequestMapping("/hello1")
    public void hello1(){
        System.out.println("spring boot demo 2 hello1 ");
    }

    @RequestMapping("/hello2")
    public void hello2(String id){
        System.out.println("hello2 id " + id);
    }

    public int add(int a,int b){
        return a+b;
    }



}
