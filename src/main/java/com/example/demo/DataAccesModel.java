package com.example.demo;

import lombok.Data;

import java.util.Date;


public class DataAccesModel {
    private String name;
    private String phone;
    private String lastAcces;
    private int atemptsADay;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastAcces() {
        return lastAcces;
    }

    public int getAtemptsADay() {
        return atemptsADay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastAcces(String lastAcces) {
        this.lastAcces = lastAcces;
    }

    public void setAtemptsADay(int atemptsADay) {
        this.atemptsADay = atemptsADay;
    }
}
