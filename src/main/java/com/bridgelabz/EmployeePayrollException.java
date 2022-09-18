package com.bridgelabz;

public class EmployeePayrollException extends Exception {
    public enum Exception {
        DATA_NULL
    }
    public Exception type;

    public EmployeePayrollException(Exception type, String message) {
        super(message);
        this.type = type;
    }
}
