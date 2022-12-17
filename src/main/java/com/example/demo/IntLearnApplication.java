package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntLearnApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IntLearnApplication.class, args);
		// GROUP BY EXAMPLE
		//#1
		String inputString = "ram raj ram kar vik vik ram raj";
    	String[] strings = inputString.split(" ");
    	List<String> stringList = Arrays.asList(strings);
    	Map<String, Long> result1 =  stringList.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()) );
    	result1.forEach((k,v) -> {
    		if (v>=1) {
    			System.out.println(k+"====="+v);
    		}
    	});
    	//#2
    	Map<Character, Long> result = inputString.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(c->c, TreeMap::new,  Collectors.counting()));
    	result.forEach((k, v) -> {
    		if (v>1) {
    			System.out.println(k+"====="+v);
    		}
    	});
    	//#3
    	Student st1 = new Student("123", "ram", "XI", 234, 11);
    	Student st2 = new Student("243", "dsf", "XI", 438, 33);
    	Student st3 = new Student("434", "arr", "XI", 438,21);
    	Student st4 = new Student("654", "rvesm", "XI", 345, 54);
    	Student st5 = new Student("554", "rvesm", "X3I", 3445, 524);
    	List<Student> studentList = new ArrayList<Student>();
    	studentList.add(st5);
    	studentList.add(st4);
    	studentList.add(st3);
    	studentList.add(st2);
    	studentList.add(st1);
    	Map<Integer, Set<Student>> markList = studentList.stream().collect(Collectors.groupingBy(s->s.getTotalMarks(), Collectors.toSet()));
    	System.out.println(markList);
    	
    	
    	//#4
    	List<Integer> ageList = studentList.stream().map(s->s.getAge()).sorted().collect(Collectors.toList());
    	System.out.println(ageList);
    	System.out.println(ageList.stream().mapToInt(s->s).summaryStatistics().getMax());
    	System.out.println(ageList.stream().mapToInt(s->s).summaryStatistics().getMin());
    	System.out.println(ageList.stream().mapToInt(s->s).summaryStatistics().getAverage());
    	System.out.println(ageList.stream().mapToInt(s->s).summaryStatistics().getSum());
	
    	System.out.println(ageList.stream().skip(1).limit(2).collect(Collectors.toList()));
	
    	List<String> nameList = studentList.stream().map(s->s.getName()).collect(Collectors.toList());
    	System.out.println(nameList);
    	System.out.println(nameList.stream().map(s->s.toUpperCase()).collect(Collectors.joining("," )));
	
	
    	//#5
    	List<String> nameList2 = studentList.stream().map(s->s.getName()).collect(Collectors.toList());
    	Set<String> uniqueNames = new HashSet<>();
    	List<String> duplicatenames =  nameList2.stream().filter(name->!uniqueNames.add(name)).collect(Collectors.toList());
	System.out.println(uniqueNames);
	System.out.println(duplicatenames);
	
	Map<String, Long> keyValueset = nameList2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	System.out.println(keyValueset);
	keyValueset.forEach((k,v) -> {
		if (v>1) {
			System.out.println(k);
		}
	});
	List<String> duplicateNAme = keyValueset.entrySet().stream().filter(v-> v.getValue()>1).map(k-> k.getKey()).collect(Collectors.toList());
	System.out.println(duplicateNAme);
	Set<String> duplicateNAmeset = nameList2.stream().filter(name -> Collections.frequency(nameList2, name) > 1 ).collect(Collectors.toSet());
	System.out.println(duplicateNAmeset);
	
	keyValueset.entrySet().forEach(s->System.out.println("test==>"+ s));
	
	//#6
	List<String> nullList = new ArrayList<>(); 
	nullList.add(null);
	nullList.add("kart");
	String value = Optional.ofNullable(nullList.get(0)).orElseThrow(() -> new NoSuchElementException("this is due to test") );
System.out.println(value);
	
	}
	
	//7
	//IntStream.(1, 10).forEach(System.out::println);
	list.forEach(s-> System.out.println(s*5));
	Collections.sort(list);
	Collections.reverse(list);
	System.out.println(list);
}
