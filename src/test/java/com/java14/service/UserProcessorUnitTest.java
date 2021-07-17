package com.java14.service;

import com.java14.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UserProcessorUnitTest {

    private AuthConnector authConnector = mock(AuthConnector.class);
    private DbConnector dbConnector = mock(DbConnector.class);
    private UserProcessor userProcessor = new UserProcessor(dbConnector, authConnector);


    @Test
    void getUserWithCategory() {
        User user = new User();
        User user1 = new User();
        User user2 = new User();

        user.setName("Bob");
        user.setPersonalCode("8735934-323");
        user.setTaxCategory("B");

        user1.setName("Lion");
        user1.setPersonalCode("876634-323");
        user1.setTaxCategory("A");

        user2.setName("Lilly");
        user2.setPersonalCode("476634-353");
        user2.setTaxCategory("C");



        List<User> paramList = new ArrayList<>();
        paramList.add(user);
        paramList.add(user1);
        paramList.add(user2);

        List<User> result = userProcessor.getUserWithCategory(paramList, "A");
        assertEquals(1, result.size());
        assertEquals("A",result.get(0).getTaxCategory());
        assertEquals(user1, result.get(0));

        result = userProcessor.getUserWithCategory(paramList, "B");
        assertEquals(1, result.size());
        assertEquals("B",result.get(0).getTaxCategory());
        assertEquals(user, result.get(0));

        result = userProcessor.getUserWithCategory(paramList, "C");
        assertEquals(1, result.size());
        assertEquals("C",result.get(0).getTaxCategory());
        assertEquals(user2, result.get(0));




    }

    @Test
    void getGrossAmountForB() {
        when(authConnector.validate()).thenReturn("123");
        Float result = userProcessor.getGrossAmountForB(100.0F);
        assertEquals(60, result,2);

        result = userProcessor.getGrossAmountForB(1000.0F);
        assertEquals(600, result, 2);
    }

    @Test
    void getGrossAmountForA() {
        Whitebox.setInternalState(userProcessor, "key","prod");
        Float result = userProcessor.getGrossAmountForA(100.0F);
        assertEquals(75, result,2);

        result = userProcessor.getGrossAmountForA(100.0F);
        assertNotEquals(40, result,2);

        verify(dbConnector, times(2)).connect();


    }
}