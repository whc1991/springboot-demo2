package com.cloud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.HandlerInterceptor;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
 @SpringBootTest
@AutoConfigureMockMvc // 自动配置MockMvc这个类
public class SpringbootDemo2ApplicationTests {

	@Test
	public void contextLoads() {
	}
    @Value("${server.port}")
	String serverPort;
	/*@Value("${payment.age}")
	Integer age;
	@Value("${payment.notify-url}")
	String notifyUrl;*/

	// 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化
    @Autowired
	private MockMvc mockMvc;
	/*@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}*/


	@Test
	public void HelloControllerTest() throws Exception {

        System.out.println(" serverPort " + serverPort);
//        System.out.println(" age " + age);
//        System.out.println(" notifyUrl " + notifyUrl);

		/*MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andReturn();

		int status = result.getResponse().getStatus();

		String content = result.getResponse().getContentAsString();

        System.out.println("status ->" + status);
            System.out.println("content ->" + content);

        Assert.assertTrue("正确",status == 200);*/

		/*MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/hello").accept(MediaType.APPLICATION_JSON))
                                              .andExpect(status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());*/
        /*byte[] bytes = result.getResponse().getContentAsByteArray();
        System.out.println(new String(bytes));
        System.out.println(result.getResponse().getContentType());
        System.out.println(result.getResponse().getCharacterEncoding());*/


//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/show").param("id","200").accept(MediaType.APPLICATION_JSON)).andReturn();


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/show").param("id","200")).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        // 输出经历的拦截器
        HandlerInterceptor[] interceptors = result.getInterceptors();
        for (HandlerInterceptor interceptor : interceptors){
            System.out.println(interceptor.getClass().getName());
        }

	}






























}
