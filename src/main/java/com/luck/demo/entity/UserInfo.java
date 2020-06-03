package com.luck.demo.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "UserInfo")
public class UserInfo implements Serializable {
    @Column(name = "USERNAME")
    private String username;

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Column(name = "AGE")
    private String age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserInfo(String username, String age) {
        this.username = username;
        this.age = age;
    }
}