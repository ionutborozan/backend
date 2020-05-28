package com.example.demo;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    public void login(LoginModel loginModel, HttpServletRequest request, HttpServletResponse response) throws SQLException {
       HttpSession session = request.getSession();
       session.setAttribute("LogedIn",loginModel.getUsername());
        Connection con =  JDBCConector.connectToDB();
        PreparedStatement statement = con.prepareStatement(Insert.loginQuery());
        statement.setInt(1,1);
        statement.setString(2,loginModel.getUsername());
        statement.setString(3,loginModel.getPassword());
        statement.setInt(4,1);
        statement.executeQuery();

    }

    public void logout(LoginModel loginModel, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        request.getAttribute("LogedIn");
        Connection con =  JDBCConector.connectToDB();
        PreparedStatement statement = con.prepareStatement(Insert.logoutQuery());
        statement.setInt(1,1);
        statement.setString(2,loginModel.getUsername());
        statement.setString(3,loginModel.getPassword());
        statement.setInt(4,0);
        statement.execute();
    }

    public DataAccesModel[] getAllNotification() throws SQLException {
        Connection con =  JDBCConector.connectToDB();
        PreparedStatement statement = con.prepareStatement(Insert.selectQuery());
        ResultSet rs = statement.executeQuery();

        List<DataAccesModel> tmp = new ArrayList<DataAccesModel>();

        while(rs.next()) {
            DataAccesModel data = new DataAccesModel();
            data.setName(rs.getString(2));
            data.setPhone(rs.getString(3));
            data.setLastAcces(rs.getString(4));
            data.setAtemptsADay(rs.getInt(5));

            tmp.add(data);
        }
        DataAccesModel[] dataAccesModels = new DataAccesModel[tmp.size()];
        tmp.toArray(dataAccesModels);


        return dataAccesModels;
    }
}
