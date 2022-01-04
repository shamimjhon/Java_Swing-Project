package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_data {

 Connection conn;

    Connection_data() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("class loaded");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "hr");
            System.out.println("connection succesful");
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new Connection_data();

    }
}
