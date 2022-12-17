package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// #1
		// shiftElementEndList();
		shiftelementEndArray();
		// #2
		// findEvenNumberList();
		// #3
		// findSumofOddNumberList();
		// #4
		// findNumberStartswithOne();
		// #5
		// findDuplicateElements();
		// #6
		// findFirstElement();
		// #7
		// findTotalNumberCount();
		// #8
		// findMaximValueList();
		// #9
		// findNonRepeatedCharString();
		// #10
		// sortElementStream();
		// #11
		// sortElementStreamReverse();
		// #12
		// findEmptyString();
		// #13
		// flatMap();
		// #14
		// sortMapByKey();

	}

	private static void shiftelementEndArray() {
		// TODO Auto-generated method stub
		int[] intialarray = { 1, 2, 3, 0, 4, 0, 5, 0 };
		int arraysize = intialarray.length;
		int count = 0;
		for (int i = 0; i < intialarray.length; i++) {
			if (intialarray[i] != 0) {
				intialarray[count] = intialarray[i];
				count++;
			} 
		}
		int noOfZeros = arraysize-count;
			while (noOfZeros > 0) {
			intialarray[count++] = 0;
			noOfZeros--;
		}

		for (int i = 0; i < intialarray.length; i++) {
			System.out.println(intialarray[i]);
		}
	}

	private static void sortMapByKey() {
		// TODO Auto-generated method stub
		Map<String, Integer> inputMap = new HashMap<>();
		inputMap.put("a", 33);
		inputMap.put("f", 55);
		inputMap.put("v", 44);
		inputMap.put("b", 67);
		inputMap.put("d", 12);
		HashMap<String, Integer> resultMap = inputMap.entrySet().stream()
				.sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(resultMap);
		// Map.Entry<String, Integer> entrySet = (Map.Entry<String, Integer>)
		// resultMap.entrySet();
		// System.out.println(entrySet.getKey()+"======="+entrySet.getValue());

	}

	private static void flatMap() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>(Arrays.asList("rasm", "sd", "", "sersr"));
		List<String> secondstringList = new ArrayList<>(Arrays.asList("878", "hg", "lkjl", "sad"));
		List<List<String>> listofLists = new ArrayList<>();
		listofLists.add(secondstringList);
		listofLists.add(stringList);
		// System.out.println(listofLists);
		listofLists.stream().flatMap(ll -> ll.stream()).collect(Collectors.toList()).forEach(System.out::println);

	}

	private static void findEmptyString() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>(Arrays.asList("rasm", "sd", "", "sersr"));
		System.out.println(stringList.stream().filter(s -> s.isEmpty()).count());
	}

	private static void sortElementStreamReverse() {
		// TODO Auto-generated method stub
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 10, 11, 5, 4, 100, 34, 4, 5, 18));
		numberList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

	}

	private static void sortElementStream() {
		// TODO Auto-generated method stub
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 10, 11, 5, 4, 100, 34, 4, 5, 18));
		numberList.stream().sorted().forEach(System.out::println);
	}

	private static void findNonRepeatedCharString() {
		// TODO Auto-generated method stub
		String nameString = "jAVa v";
		Character result = nameString.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(v -> v.getValue() == 1L).map(k -> k.getKey()).findFirst().get();
		System.out.println(result);

	}

	private static void findMaximValueList() {
		// TODO Auto-generated method stub
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 10, 11, 5, 4, 100, 34, 4, 5, 18));
		System.out.println(numberList.stream().max(Integer::compare).get());

	}

	private static void findTotalNumberCount() {
		// TODO Auto-generated method stub
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 10, 11, 5, 4, 100, 34, 4, 5, 18));
		System.out.println(numberList.stream().count());
	}

	private static void findFirstElement() {
		// TODO Auto-generated method stub
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 10, 11, 5, 4, 100, 34, 4, 5, 18));
		numberList.stream().findFirst().ifPresent(System.out::println);
	}

	private static void findDuplicateElements() {
		// TODO Auto-generated method stub
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 10, 11, 5, 4, 100, 34, 4, 5, 18));
		Set<Integer> nonDupElementSet = new HashSet<>();
		Set<Integer> duplicateElements = numberList.stream().filter(n -> !nonDupElementSet.add(n))
				.collect(Collectors.toSet());
		nonDupElementSet.forEach(System.out::println);
		duplicateElements.forEach(System.out::println);
	}

	private static void findNumberStartswithOne() {
		// TODO Auto-generated method stub
		StringJoiner sj = new StringJoiner(", ");
		List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 20, 11, 23, 14, 100, 34, 4, 5, 18));
		numberList.stream().map(n -> n + "").filter(n -> n.startsWith("1")).forEach(s -> sj.add(s));
		System.out.println(sj);

		// else

		String value = numberList.stream().map(n -> n + "").filter(n -> n.startsWith("1"))
				.collect(Collectors.joining(","));
		System.out.println(value);
	}

	private static void findSumofOddNumberList() {
		// TODO Auto-generated method stub
		List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9));
		List<Integer> oddList = numberList.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
		oddList.forEach(System.out::println);
		long oddNumberSum = oddList.stream().mapToInt(s -> s).summaryStatistics().getSum();
		System.out.println("oddNumberSum==>" + oddNumberSum);
	}

	private static void findEvenNumberList() {
		List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		List<Integer> evenNumList = numberList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		evenNumList.forEach(System.out::println);
		// TODO Auto-generated method stub

	}

	private static void shiftElementEndList() {

		// 1,3,0,4,0,5,0,34
		// 1,3,4,5,34,0,0,0
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 0, 4, 0, 5, 0, 34));
		// .list.forEach(i->i*5);
		int count = 0;
		int elementShifted = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == elementShifted) {
				count++;
				list.remove(i);
			}

		}
		for (int i = 0; i < count; i++) {
			list.add(elementShifted);
		}

		list.stream().forEach(s -> System.out.println(s));
	}

}
