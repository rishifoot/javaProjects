package com.nagarro.priorityqueue;

public class PriorityQueues {
	int arr[];
	int size;
	int number;
	int front;
	PriorityQueues(int size){
		arr=new int[size];
		this.size=size;
		number=0;
		front=0;
	}
	public boolean isFull() {
		try {
		return number==size;
		}catch(Exception e) {
			System.out.println("index out of bound exception");
		
		}
		return false;
	}
	
	
	public boolean isEmpty() {
		try {
		return number==0;
		}catch(Exception e) {
			System.out.println("index out of bound exception ");
		}
		return false;
	}
	
	
	
	public void enqueue(int value) {
		try {
		int i;
		if(isFull()) {
			System.out.println("queue is full");
			return;
		}
		if(number==0) {
			arr[number++]=value;
		}
		else {
		for( i=number-1;i>=0;i--) {
			if(value>arr[i]) {
				arr[i+1]=arr[i];
			}
			else
				break;
		}
		arr[++i]=value;
		number++;
		
		}
		}catch(Exception e) {
			System.out.println("index out of bound exception");
			return;
		}
	}
	
	
	public int dequeue() {
		try {
		if(isEmpty()) {
			return -1;
		}
		return arr[--number];
		}catch(Exception e) {
			System.out.println("index out of bound exception");
			return 0;
		}
	}
	
	
	public int peek() {
		try {
		if(isEmpty())
			return -1;
		return arr[number-1];
		}catch(Exception e) {
			System.out.println("index out of bound exception ");
			return 0;
		}
	}
	
	
	public int center() {
		try {
		if(isEmpty()) {
			System.out.println("queue is empty");
			return -1;
		}
		int middle=(0+number)/2;
		return arr[middle];
		}catch(Exception e) {
			System.out.println("index out of bound exception");
			return Integer.MIN_VALUE;
		}
	}
	
	public int size() {
		try {
		return number -0;
		}catch(Exception e) {
			System.out.println("index out of exception");
			return Integer.MIN_VALUE;
		}
	}
	
	
	public void reverse() {
		try {
		int i=0;
		int j=number-1;
		while(i<j) {
			int temp=arr[i];
			arr[i++]=arr[j];
			arr[j--]=temp;
		}
		}catch(Exception e) {
			System.out.println("index out of bound exception ");
			return;
		}
	}
	
	public boolean contains(int x) {
		if(isEmpty()) {
			return false;
		}
		for(int i=0;i<number;i++) {
			if(arr[i]==x)
				return true;
		}
		return false;
	}
	public void print() {
		try {
		for(int i=0;i<number;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		}catch(Exception e) {
			System.out.println("index out of bound exception ");
			return;
		}
	}
	
	

	public static void main(String[] args) {
		PriorityQueues pq=new PriorityQueues(7);
		pq.enqueue(21);
		pq.enqueue(34);
		pq.enqueue(87);
		pq.enqueue(11);
		pq.enqueue(10);
		pq.enqueue(5);
		pq.enqueue(6);
		//pq.enqueue(65);
		System.out.println("size of the stack is " +pq.size());
		
		//pq.reverse();
		pq.print();
		//System.out.println("removing element from queue " +pq.dequeue());
		System.out.println("size of the stack is " +pq.size());
		System.out.println(pq.contains(5));
		System.out.println("center element of queue is " +pq.center());
		System.out.println("peek element of stack is "+ pq.peek());
		
		//System.out.println("removing element from queue " +pq.dequeue());
		System.out.println("peek element of stack is "+ pq.peek());
		//System.out.println("removing element from queue " +pq.dequeue());
		System.out.println("size of the stack is " +pq.size());
	
		System.out.println("center element of the queue is " +pq.center());
		System.out.println("peek element of stack is "+ pq.peek());
		System.out.println("size of the stack is " +pq.size());
		pq.print();
		
		
		

	}

}
