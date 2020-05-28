package com.example.demo;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class JDBCConector {


    public static Connection connectToDB() {

        try {
            URL u = new URL("jar:file:C:\\ws\\myStuffs\\projectSII\\src\\main\\java\\com\\example\\demo\\mysql-connector-java-8.0.15.jar!/");
            String classname = "com.mysql.cj.jdbc.Driver";
            URLClassLoader ucl = new URLClassLoader(new URL[]{u});
            Driver d = (Driver) Class.forName(classname, true, ucl).newInstance();
            DriverManager.registerDriver(new DriverShim(d));

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projectsi", "root", "root");
            return con;
        } catch (Exception e) {
            return null;
        }
    }


}


