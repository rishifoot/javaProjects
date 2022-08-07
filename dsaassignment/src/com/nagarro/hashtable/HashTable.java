package com.nagarro.hashtable;

public class HashTable {

	public static void main(String[] args)throws Exception {
		MyHashMap<String,Integer> map=new MyHashMap();
		map.put("d", 1);
		map.put("e", 2);

		map.put("l", 3);
		System.out.println("the value of key is "+ map.getKey("l"));
		System.out.println("remove key from map "+map.remove("d"));
		System.out.println(map.containsKey("e"));
		
		map.print();

		
	}
	
}
