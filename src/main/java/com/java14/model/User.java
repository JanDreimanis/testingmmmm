package com.java14.model;

import java.util.Objects;

public class User {
    private String name;
    private String personalCode;
    private String taxCategory;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    @Override
    public String toString() {
        return "com.java14.model.User{" +
                "name='" + name + '\'' +
                ", personalCode='" + personalCode + '\'' +
                ", taxCategory='" + taxCategory + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getName().equals(user.getName()) && getPersonalCode().equals(user.getPersonalCode()) && getTaxCategory().equals(user.getTaxCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPersonalCode(), getTaxCategory());
    }
}
