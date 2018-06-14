package com.cloud.test;
//Let's import Mockito statically so that the code looks clearer

import com.cloud.test.domain.Account;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.listeners.MockitoListener;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by wanghc on 2018/6/13.
 */

public class MockitoTest {


    @Test
    public void mTest() throws Exception {

        /*List<String> list = mock(List.class);

        when(list.get(0)).thenReturn("helloworld");

        String result = list.get(0);

        verify(list).get(0);

        Assert.assertEquals("helloworld",result);
        when(list.get(0)).thenReturn("first");
        when(list.get(0)).thenReturn("oops");
        System.out.println(list.get(0));
        System.out.println(list.get(0));*/


        // 创建mock对象
        HelloController mockHello = mock(HelloController.class);
        // 设置方法的预期返回值
        when(mockHello.hello()).thenReturn("helloController.hello");
//        when(mockHello.hello()).thenThrow(new RuntimeException("test exception"));

        String result = mockHello.hello();
        // 验证方法是否调用
        verify(mockHello).hello();
        // 验证hello方式是否调用了两次
        verify(mockHello,times(1)).hello();
        // junit测试
        Assert.assertEquals("helloController.hello",result);

        //doNothing().when(mockHello).hello2("123");
        // 控制台无打印
        mockHello.hello2("123");

        verify(mockHello,times(1)).hello2("123");

        // mock对象无法调用真实的方法，
        // spy对象可以监视真实的方法
        // HelloController spyHello = spy(HelloController.class);

        /*when(spyHello.hello()).thenReturn("1111");

        System.out.println(spyHello.hello());*/

        // doNothing().when(spyHello).hello2("123");
        // 加上上面一句doNoting 不会有数据打印
        // 调用监视对象真实的方法传递参数
        // spyHello.hello2("123");



       /* List<String> list = mock(List.class);

        when(list.get(anyInt())).thenReturn("hello","world");

        String result = list.get(0)+list.get(1);
        // 如果使用参数匹配器，那么所有的参数都要使用参数匹配器，不管是stubbing还是verify的时候都一样。

        verify(list,times(2)).get(anyInt());

        Assert.assertEquals("helloworld", result);*/

        /**
         * 对void方法进行方法预期设定
         * doNothing()模拟不做任何返回
         */

        /*HelloController mockhello1 = mock(HelloController.class);
        // 迭代编写风格 第一次不做任何操作，第二次抛出异常
        doNothing().doThrow(new RuntimeException("test exception")).when(mockhello1).hello1();

        mockhello1.hello1();

        mockhello1.hello1();

        verify(mockhello1,times(1)).hello1();*/


        /*Account mockAccount = mock(Account.class,RETURNS_DEEP_STUBS);

        when(mockAccount.getTicket().getName()).thenReturn("isTicket()");

        System.out.println(mockAccount.getTicket().getName());*/





    }
}
