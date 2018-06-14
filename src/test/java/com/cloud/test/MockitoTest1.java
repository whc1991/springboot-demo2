package com.cloud.test;

import com.cloud.test.domain.Account;
import com.cloud.test.domain.Ticket;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;


/**
 * Created by wanghc on 2018/6/13.
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest1 {

    @Mock
    private Ticket ticket;
    @InjectMocks
    private Account account;

    @Mock
    private HelloController helloController;

    @Spy
    private HelloController helloController1;


    @Test
    public void accountTest() throws Exception {

        when(account.getTicket().getName()).thenReturn("isTicket()");

        System.out.println(account.getTicket().getName());

        when(helloController.add(1,2)).thenReturn(4);
        int ab = helloController.add(1,2);
        Assert.assertEquals(3,ab);
        System.out.println("ab --> " + ab);

        int abspy = helloController1.add(2,3);
        System.out.println("abspy --> " + abspy);

    }
}
