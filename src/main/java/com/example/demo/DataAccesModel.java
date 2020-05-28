package com.example.demo;

import lombok.Data;

import java.util.Date;

@Data
public class DataAccesModel {
    private String name;
    private String phone;
    private String lastAcces;
    private int atemptsADay;

}
