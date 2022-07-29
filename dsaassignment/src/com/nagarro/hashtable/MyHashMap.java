package com.nagarro.hashtable;

import java.util.LinkedList;

public class MyHashMap<k,v> {
	private class HMNode{
		k key;
		v value;
		HMNode(k key,v value){
			this.key=key;
			this.value=value;
		}
	}
	private int size;
	LinkedList<HMNode>[] container;
	
	public MyHashMap() {
		initContainer(4);
		size=0;
		
	}
	
	public void initContainer(int N) {
		container=new LinkedList[N];
		for(int i=0;i<container.length;i++) {
			container[i]=new LinkedList<>();
		}
	}
	public void put(k key,v value) throws Exception{
		int hc=hashFunction(key);
		int di=getIndexwithincontainer(key,hc);
		
		if(di!=-1) {
			HMNode node=container[hc].get(di);
			node.value=value;
		}
		else {
			HMNode node=new HMNode(key,value);
			container[hc].add(node);
			size++;
			
		}
		
	}
	public boolean containsKey(k key) throws Exception{
		int hc=hashFunction(key);
		int di=getIndexwithincontainer(key,hc);
		if(di!=-1) {
			return true;
		}
		else {
			return false;
			
		}
		
	}
	
	public v getKey(k key)throws Exception{
		int hc=hashFunction(key);
		int di=getIndexwithincontainer(key,hc);
		if(di!=-1) {
			HMNode node =container[hc].get(di);
			return node.value;
		}
		else {
			return null;
			
		}
	}
	
	public v remove(k key)throws Exception{
		int hc=hashFunction(key);
		int di=getIndexwithincontainer(key,hc);
		if(di!=-1) {
			HMNode node=container[hc].remove(di);
			size--;
			return node.value;
		}
		else {
			return null;
			
			
		}
	}
	
	public int size() {
		return size;
	}
	
	
	public int hashFunction(k key) {
		int hc=key.hashCode();
		return Math.abs(hc)%container.length;
	}
	
	
	public int getIndexwithincontainer(k key,int ci) {
		int di=0;
		for(HMNode node:container[ci]) {
			if(node.key.equals(key)) {
				return di;
			}
			di++;
		}
		return -1;
	}
	
	public void print() {
		for(int i=0;i<container.length;i++) {
			System.out.println("container "+ i);
			for(HMNode node:container[i]) {
				System.out.println(node.key+ " --> " +node.value);
			}
		}
	}
	

}
