package com.cloud.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootDemo2ApplicationTests {

	@Test
	public void contextLoads() {
	}
    @Value("${server.port}")
	String serverPort;

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}


	@Test
	public void HelloControllerTest() throws Exception {

        System.out.println(" serverPort " + serverPort);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andReturn();

		int status = result.getResponse().getStatus();

		String content = result.getResponse().getContentAsString();

        System.out.println("status ->" + status);
            System.out.println("content ->" + content);

//        Assert.assertTrue("正确",status != 200);
        Assert.assertTrue("正确",status == 200);

	}






























}
