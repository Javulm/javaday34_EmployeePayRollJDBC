package com.bridgelabz;

import java.sql.*;

public class EmployeePayrollJDBC {
    public static void main(String[] args) {
        String query = "select * from employee_payroll";
        String query1 = "update employee_payroll set basicPay=4500000.00 where id ='2' or name='Teresa'";
        Connection con = EmployeePayrollConnection.createConnection();
        try {
            PreparedStatement stm1 = con.prepareStatement(query1);
            int resultSet1 = stm1.executeUpdate(query1);
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            if(resultSet1!=0){
                System.out.println("data updated");
            }else {
                throw new EmployeePayrollException(EmployeePayrollException.Exception.DATA_NULL, "Data update failed");
            }
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
        } catch (SQLException | EmployeePayrollException e) {
            e.printStackTrace();
        }
    }
}
