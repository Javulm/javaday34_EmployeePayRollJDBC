package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayrollConnection {
        static Connection con=null;

    public static Connection createConnection(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded Successfully");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_services", "root", "javul1802");
        System.out.println("connection successful!!!");
    } catch (ClassNotFoundException | SQLException exception) {
        throw new IllegalStateException("Cannot find driver in the classpath", exception);
        }
    return con;
    }
}