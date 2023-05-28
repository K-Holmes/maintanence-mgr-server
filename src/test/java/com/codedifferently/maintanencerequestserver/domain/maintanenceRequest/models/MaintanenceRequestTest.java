package com.codedifferently.maintanencerequestserver.domain.maintanenceRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class MaintanenceRequestTest {
    @Test
    public void constructorTest01(){
        Date d1 = new Date();
        MaintanenceRequest maintanenceRequest = new MaintanenceRequest("Demo","User", "demo@user.com", "A101", "broken window", d1);
        maintanenceRequest.setId(1l);

        String expected = "1 Demo User demo@user.com A101 broken window "+d1;
        String actual = maintanenceRequest.toString();

        Assertions.assertEquals(expected, actual);
        System.out.println(d1);
    }
}
