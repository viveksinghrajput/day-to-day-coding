package com.java8;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDto.getEmployeeList();

        //1. Group the Employees by city and print name.
        Map<String, List<String>> collect =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));
            /*System.out.print(collect);*/

       //2. Nth Highest salary of employee with name for distinct salary
        long n = 2;
        Optional<Employee> first = employeeList.stream().sorted(
                Comparator.comparing(Employee::getSalary).reversed()
        ).skip(n - 1).findFirst();
        /*first.ifPresent(employee -> System.out.println(employee.getName() + " " + employee.getSalary()));*/

        Optional<Employee> sec = employeeList.stream().sorted((o1, o2) -> {
            return Math.toIntExact(o2.getSalary() - o1.getSalary());
        }).skip(n - 1).findFirst();
       /* sec.ifPresent(employee -> System.out.print(sec.get().getName()+" "+sec.get().getSalary()));*/


        //3. find the nth highest salary of organisation if salary is duplicate
        List<Map.Entry<Long, List<String>>> nthSalary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())))
                .entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());
        /*System.out.println(nthSalary.get(1));*/

        List<Map.Entry<Long, List<String>>> nthSalary1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())))
                .entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());
        /*System.out.print(nthSalary1.get(1));*/

      //4.  Group the Employees by age.
        Map<Integer, List<Employee>> groupEmpByAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
        /*System.out.println(groupEmpByAge);*/
        Map<Integer, List<String>> groupNameByAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
        /*System.out.println(groupNameByAge);*/
        //5.  Find the count of male and female employees present in the organization.
        Map<String, Long> maleAndFemaleCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        /*System.out.println(maleAndFemaleCount);*/

        //6. Print the names of all departments in the organization.
        List<String> nameOfAllDepart = employeeList.stream().map(Employee::getDeptName).distinct().collect(Collectors.toList());
        /*System.out.println(nameOfAllDepart);*/

        //7. Print employee details whose age is greater than 28.

        List<Employee> employeeDetailsAgeMoreThan28 = employeeList.stream().filter(employee -> employee.getAge() > 28).collect(Collectors.toList());
        /*employeeDetailsAgeMoreThan28.forEach(System.out::println);*/

        //8. Find maximum age of employee.
        Optional<Employee> maxAge = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
       /* maxAge.ifPresent(employee -> System.out.println(employee.getName()+" "+employee.getAge()));*/

        Employee employee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst().get();
       /* System.out.println(employee.getName()+" "+employee.getAge());*/

        //9. Print Average age of Male and Female Employees.
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)))
                .forEach((key, value) -> System.out.println(key + " " + value));*/

        //10. Print the number of employees in each department.
        /*employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
                .forEach((key,val)->System.out.println(key+ " "+val));*/

        //11. Find oldest employee.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getYearOfJoining,Collectors.mapping(Employee::getName,Collectors.toList())))
                .entrySet().stream().min(Map.Entry.comparingByKey()).ifPresent(System.out::println);

        //12. Find youngest female employee.
        employeeList.stream().filter(e->e.getGender().equalsIgnoreCase("Female"))
                .collect(Collectors.groupingBy(Employee::getYearOfJoining,Collectors.mapping(Employee::getName,Collectors.toList())))
                .entrySet().stream().max(Map.Entry.comparingByKey()).ifPresent(System.out::println);

        //13. Find employees whose age is greater than 30 and less than 30.
        employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30)).entrySet().stream()
                .forEach(booleanListEntry -> {
                    if (Boolean.TRUE.equals(booleanListEntry.getKey())){
                        booleanListEntry.getValue().stream().map(Employee::getName).forEach(System.out::println);

                    }else {
                        booleanListEntry.getValue().stream().map(Employee::getName).forEach(System.out::println);
                        System.out.println();
                    }
                });

        employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30,Collectors.mapping(Employee::getName,Collectors.toList())))
                .entrySet().stream().forEach(entry->{
                    if (Boolean.TRUE.equals(entry.getKey())){
                        System.out.println(entry.getValue());
                    }else {
                        System.out.println(entry.getValue());
                        System.out.println();
                    }
                });

        //13. Find the department name which has the highest number of employees.
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
                .entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet().stream().max(Map.Entry.comparingByKey())
                .ifPresent(s->s.getValue().stream().collect(Collectors.mapping(Map.Entry::getKey,Collectors.toList())).forEach(System.out::println));

        //14. Find if there any employees from HR Department.
        List<Employee> hrEmployee = employeeList.stream()
                .filter(emp -> emp.getDeptName().equalsIgnoreCase("HR"))
                .collect(Collectors.toList());
        /*System.out.println(hrEmployee);*/

        //15. Find the department names that these employees work for, where the number of employees in the department is  2.
        System.out.println();
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
                .entrySet().stream().forEach(deptCount->{
                    if (deptCount.getValue()>=2){
                        System.out.println(deptCount.getKey());
                    }
                });
        // or
        System.out.println();
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
                .entrySet().stream().filter(depCount-> depCount.getValue()>=2).forEach(s->System.out.println(s.getKey()));

        //16. Find distinct department names that employees work for.
        System.out.println();
        employeeList.stream()
                .map(Employee::getDeptName)
                .distinct()
                .forEach(System.out::println);

        //17. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
        System.out.println();
        employeeList.stream().filter(emp->emp.getCity().equalsIgnoreCase("Blore"))
                .map(Employee::getName)
                .sorted().forEach(System.out::println);

        //18. No of employees in the organisation.
        System.out.println();
        System.out.println( employeeList.stream().count());

        //19. Find employee count in every department
        System.out.println();
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
                .forEach((key,val)-> System.out.println(key+" "+val));

        //20. Find the department which has the highest number of employees.
        System.out.println();
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
                .entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet().stream().max(Map.Entry.comparingByKey())
                .ifPresent(s-> s.getValue().stream().map(Map.Entry::getKey).collect(Collectors.toList()).forEach(System.out::println));

        //21 . Sorting a Stream by age and name fields.
        System.out.println();
        employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparingInt(Employee::getAge)).forEach(System.out::println);

        //22. Print average and total salary of the organization.
        DoubleSummaryStatistics empSalary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average salary "+empSalary.getAverage());
        System.out.println("Total salary "+empSalary.getSum());

        //23. Print Average salary of each department.
        System.out.println();
         employeeList.stream()
                 .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.averagingDouble(Employee::getSalary)))
                 .entrySet().stream().forEach(e1->System.out.println(e1.getKey() +" "+e1.getValue()));

         //24. Sort the employees salary in each department in ascending order
        System.out.println();
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.collectingAndThen(Collectors.toList(),
                        list->list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)))))
                .entrySet().stream().forEach(k->System.out.println(k.getKey()+" "+k.getValue().collect(Collectors.toList())));
    }
}
