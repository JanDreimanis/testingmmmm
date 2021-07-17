package com.java14.service;

import com.java14.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserProcessor {

    private final DbConnector dbConnector;
    private final AuthConnector authConnector;
    private String key = "dwsqhlkjgbcf";

    public UserProcessor(DbConnector dbConnector, AuthConnector authConnector) {
        this.dbConnector = dbConnector;
        this.authConnector = authConnector;
    }

    public List<User> getUserWithCategory(List<User> users, String taxCategory) {
        dbConnector.connect();
        List<User> result = new ArrayList<>();
        for ( User user: users  ) {
            if (user.getTaxCategory().equals(taxCategory)) {
                result.add(user);
            }
        }
        return result;
    }

    public Float getGrossAmountForB(Float amount) {
        if (authConnector.validate().equals("123")) {
            dbConnector.connect();
            return amount * 0.6F;
        } else {
            return 0F;
        }
    }

    public Float getGrossAmountForA(Float amount) {
        if (!key.equals("prod")) {
            throw new RuntimeException();
        }
        dbConnector.connect();
        return amount * 0.75F;
    }



}
