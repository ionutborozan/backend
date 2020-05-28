package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.extern.slf4j.Slf4j;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api/")
public class LoginController {

     @Autowired
     private LoginService loginService;

    @PostMapping(path = "/login")
    public void login(@RequestBody LoginModel loginModel, HttpServletRequest request, HttpServletResponse response) throws SQLException {

         loginService.login(loginModel,request,response);
    }

    @PostMapping(path = "/logout")
    public void logout(@RequestBody LoginModel loginModel,HttpServletRequest request,HttpServletResponse response) throws SQLException {

        loginService.logout(loginModel,request,response);
    }

    @GetMapping(path = "/notification")
    public DataAccesModel[] getAllNotification() throws SQLException {
        return loginService.getAllNotification();
    }



}
