package com.cloud.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * Created by wanghc on 2018/6/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testHome() throws Exception {


        String content = testRestTemplate.postForObject("/user/home",null,String.class);
        Assert.assertEquals("user home",content);
    }

    @Test
    public void testShow() throws Exception {

        MultiValueMap map = new LinkedMultiValueMap();
        map.add("id","200");
        String content = testRestTemplate.postForObject("/user/show",map,String.class);
        System.out.println(content);
    }


    @Test
    public void testDetail() throws Exception {

        // String content = testRestTemplate.postForObject("/user/detail",null,String.class);
//        System.out.println("content --> " + content);

        Map<String,Object> map = testRestTemplate.postForObject("/user/detail",null,Map.class);
        // System.out.println(map.size());
        System.out.println((Integer) map.get("id") + (String)map.get("name"));

        for (Map.Entry<String,Object> entry : map.entrySet()){
            System.out.println(entry.getKey() + "  --  " +entry.getValue());
        }
    }
}
