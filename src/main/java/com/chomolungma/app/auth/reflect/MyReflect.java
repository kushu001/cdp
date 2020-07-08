package com.chomolungma.app.auth.reflect;


public class MyReflect extends ParentReflect {

    private String name = "hello";
    private String gender = "male";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
