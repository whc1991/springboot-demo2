package com.cloud.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghc on 2018/6/11.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "spring boot demo 2";
    }



}