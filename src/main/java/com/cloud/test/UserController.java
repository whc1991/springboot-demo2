package com.cloud.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghc on 2018/6/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    // @PostMapping("/home")
    @RequestMapping("/home")
    public String home(){

        return "user home";
    }



    @RequestMapping("/show")
    public String show(String id){

        return "user show " + id;
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Map<String,Object> detail(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",2);
        map.put("name","zhangsan");
        return map;
    }
}
