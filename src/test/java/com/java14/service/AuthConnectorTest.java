package com.java14.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ApplicationException;

import static org.junit.jupiter.api.Assertions.*;

class AuthConnectorTest {
    private AuthConnector authConnector = new AuthConnector();

    @Test
    void validate() {

        String result = authConnector.validate();

        assertEquals("abc", result);
    }

    @Test
    void something() {

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {

            authConnector.something();
        });
        String actualMessage = exception.getMessage();
        assertEquals("12345",actualMessage);

    }

    //    @Test
//    void something() {
//        try {
//            authConnector.something();
//            fail();
//        } catch (Exception e) {
//            assertEquals("12345", e.getMessage());
//        }                                                                  classic way
//    }
}