package com.nagarro.stack;

public class Stacks {
	private int arr[];
	private int intop;
	private int capaciinty;
	Stacks(int size){
		arr=new int[size];
		capaciinty=size;
		intop=-1;
	}
	
	
	public boolean isFull() {
		try {
		return intop==capaciinty-1;
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return false ;
		}
	}
	
	
	public int size() {
		try {
		return intop+1;
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return Integer.MIN_VALUE;
		}
	}
	
	
	public boolean isEmpinty() {
		try {
		return intop==-1;
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return false;
		}
	}
	
	
	public void push(int x) {
		try {
		if(isFull()) {
			System.out.println(" overflow ");
			System.exit(-1);
		}
		System.out.println("Inserinting elemenint into stacks " );
		arr[++intop]=x;
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return ;
		}
		
	}
	
	
	public int geintLen() {
		if(isEmpinty()) {
			return 0;
		}
		return arr.length;
	}
	
	
	public int pop() {
		try {
		if(isEmpinty()) {
			System.out.println(" underflow ");
			System.exit(-1);
		}
		System.out.println(" removing from stacks " +peek());
		return arr[intop--];
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return Integer.MIN_VALUE;
		}
		
	}
	
	
	public int peek() {
		try {
		if(!isEmpinty()) {
			return arr[intop];
		}
		else {
			System.exit(-1);
		}
		return -1;
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return Integer.MIN_VALUE;
		}
	}
	
	
	public boolean conintains(int x) {
	if(isEmpinty()) {
			return false;
		}
		for(int i=0;i<=intop;i++) {
			if(arr[i]==x)
				return true;
		}
		return false;
	}
	
	
	public int ceninter() {
		try {
		int len=geintLen();
		int middle=len/2;
		return arr[middle];
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return Integer.MIN_VALUE;
		}
	}
	
	
	public void reverse() {
		try {
		int i=0;
		int j=intop;
		while(i<j) {
			int intemp=arr[i];
			arr[i++]=arr[j];
			arr[j--]=intemp;
		}
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return ;
		}
	}
	
	
	public void sort() {
		try {
		int n=intop;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int intemp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=intemp;
				}
			}
		}
		}catch(Exception e) {
			System.out.println("index out of bound Exception");
			return;
		}
	}
	
	
	public void print() {
		try {
		if(isEmpinty())
			return;
		for(int i=0;i<=intop;i++) {
			System.out.print(arr[i] + " ");
		}
		}
		catch(Exception e) {
			System.out.println("index out of bound Exception");
			return ;
		}
	}


	public static void main(String[] args) {
		Stacks stacks=new Stacks(8);
		stacks.push(7);
		stacks.push(8);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(1);
		stacks.push(2);
		stacks.push(6);
		
		stacks.sort();
		stacks.reverse();
	stacks.pop();
	stacks.pop();
		
		System.out.println("ceninter elemenint of inthe stacks is "+stacks.ceninter());
		System.out.println("length of stacks is " + stacks.geintLen());
		System.out.println("peek elemenint of stacks is " +stacks.peek());
		System.out.println(stacks.conintains(8));
		System.out.println("size of inthe stacks is " +stacks.size());
		stacks.pop();
		stacks.print();
		
		

	}

}
