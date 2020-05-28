package com.example.demo;

public class Insert {

    public static String loginQuery() {

        return  " select * from login_inf where username = ? and password = ? ";
    }

    public static String logoutQuery() {
        return "update user_login set status=0 where username = ? and password = ?";
    }

    public static String selectQuery() {
        return "select * from notification";
    }
}
