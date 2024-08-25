package com.java8;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {

    public static List<Employee> getEmployeeList(){

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "vivek", 28, 123, "Male", "HR", "Blore", 2020));
        employeeList.add(new Employee(2, "jyoti", 29, 120, "Female", "ADMIN", "Hyderabad", 2015));
        employeeList.add(new Employee(3, "sachin", 30, 115, "Male", "HR", "Chennai", 2014));
        employeeList.add(new Employee(4, "anshu", 32, 125, "Female", "ADMIN", "Chennai", 2013));

        employeeList.add(new Employee(5, "ankush", 22, 150, "Male", "IT", "Noida", 2013));
        employeeList.add(new Employee(6, "prabhat", 27, 140, "Male", "IT", "Gurugram", 2017));
        employeeList.add(new Employee(7, "sonu", 26, 130, "Male", "EE", "Pune", 2016));
        employeeList.add(new Employee(8, "monu", 23, 160, "Male", "CS", "Trivandam", 2015));
        employeeList.add(new Employee(9, "prity", 25, 160, "Female", "BIO", "Blore", 2010));


        employeeList.add(new Employee(10, "bittu", 22, 150, "Female", "CIVIL", "Noida", 2013));
        employeeList.add(new Employee(11, "bunty", 27, 140, "Male", "ME", "Gurugram", 2017));
        employeeList.add(new Employee(12, "rinki", 26, 130, "Female", "EN&TC", "Pune", 2016));
        employeeList.add(new Employee(13, "anjan", 23, 160, "Male", "EEE", "Trivandam", 2015));
        employeeList.add(new Employee(14, "pooja", 25, 160, "Female", "CS", "Blore", 2010));

        return employeeList;
    }
}
