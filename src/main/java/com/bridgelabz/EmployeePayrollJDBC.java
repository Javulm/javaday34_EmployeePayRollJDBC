package com.bridgelabz;

import java.sql.*;

public class EmployeePayrollJDBC {
    public static void main(String[] args) {
        String query = "select * from employee_payroll";
        String query2 = "select avg(basicPay) as avg, sum(basicPay) as sum, min(basicPay) as min, max(basicPay) as max from employee_payroll where gender = 'F' group by gender";
        Connection con = EmployeePayrollConnection.createConnection();
        try {
            Statement stm1 = con.createStatement();
            ResultSet resultSet = stm1.executeQuery(query);
            Statement stm2 = con.createStatement();
            ResultSet resultSet1 = stm2.executeQuery(query2);

            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Gender: " + resultSet.getString("gender"));
                System.out.println("Salary: " + resultSet.getString("salary"));
                System.out.println("start Date: " + resultSet.getDate("startDate"));
                System.out.println("Phone: " + resultSet.getInt("Phone"));
                System.out.println("Department: " + resultSet.getString("Department"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("basicPay: " + resultSet.getDouble("basicPay"));
                System.out.println("Deductions: " + resultSet.getDouble("Deductions"));
                System.out.println("TaxablePay: " + resultSet.getDouble("TaxablePay"));
                System.out.println("IncomeTax: " + resultSet.getDouble("IncomeTax"));
                System.out.println("NetPay: " + resultSet.getDouble("NetPay"));
                System.out.println("*********************************");
            }
            while (resultSet1.next()) {
                double average = resultSet1.getDouble("avg");
                double sum = resultSet1.getDouble("sum");
                double min = resultSet1.getDouble("min");
                double max = resultSet1.getDouble("max");
                System.out.println("Average of basic_pay : " + average + "\nsum of basic_pay : " + sum + "\nMinimum of basic_pay : " + min + "\nMaximum of basic_pay : " + max);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
