package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIAdvanceMethod {
    public static void main(String[] args) {

        //Stream.ofNullable
        List<String> names = Arrays.asList("vivek","jyoti","sachin",null,"ankush",null,"prabhat");
        List<String> nonNullnames = names.stream()
                .flatMap(Stream::ofNullable)
                .collect(Collectors.toList());
       // System.out.println(nonNullnames);

        //Stream.iterate
        Stream.iterate(0,n->n+2)
                .limit(5)
                .forEach(System.out::println);

        //Collectors.collectingAndThen
            //calculate the avg salary and round up to nearest integer
        List<Employee> employeeList = EmployeeDto.getEmployeeList();
        Long avgSalary = employeeList
                .stream()
                .mapToDouble(Employee::getSalary)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(Double::doubleValue), Math::round));
       // System.out.println(avgSalary);

        //Stream takeWhile and Stream dropWhile
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> takeWhile = numbers
                .stream()
                .takeWhile(n -> n < 5)
                .collect(Collectors.toList());
        System.out.println(takeWhile);

        List<Integer> dropWhile = numbers
                .stream()
                .dropWhile(n -> n < 5)
                .collect(Collectors.toList());
        System.out.println(dropWhile);

        //Collectors teeing
        Map<String, Integer> maxMinValue = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.minBy(Integer::compareTo),
                        (e1, e2) -> Map.of("max", e1.get(), "min", e2.get())
                ));
        System.out.println(maxMinValue);

        //Stream concat
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4);
        Stream<Integer> integerStream2 = Stream.of(5, 6, 7, 8, 9);
        Stream<Integer> concatIntegerStream = Stream.concat(integerStream1, integerStream2);
        int sum = concatIntegerStream.mapToInt(Integer::intValue).sum();
        System.out.println(sum);


        //Collectors.partitioningBy
        Map<Boolean, List<Integer>> partitioningByNum = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Even Num : "+partitioningByNum.get(Boolean.TRUE)+" "+"Odd Num : "+partitioningByNum.get(Boolean.FALSE));

        //IntStream for Ranges
        List<Integer> rangesOfNum = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
        System.out.println(rangesOfNum);
//skip() and limit() method
        List<Integer> integerList = numbers.stream()
                .skip(1)
                .limit(7)
                .collect(Collectors.toList());
        System.out.println(integerList);

    }
}
