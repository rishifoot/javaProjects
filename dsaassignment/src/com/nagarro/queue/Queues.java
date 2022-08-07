package com.nagarro.queue;

public class Queues {
	private int arr[];
	private int capacity;
	int front;
	int rear;
	Queues(int capacity){
		arr=new int[capacity];
		this.capacity=capacity;
		front =rear=0;
	}
	
	
	public int size() {
		try {
		return rear-front;
		}
		catch(Exception e) {
			System.out.println("index out of bound exception");
			return Integer.MIN_VALUE;
		}
	}
	
	
	public void enqueue(int x) {
		try {
		if(capacity==rear) {
			System.out.println("Queue is full");
			return;
		}
		arr[rear++]=x;
	}
		catch(Exception e) {
			System.out.println("index out of bound exception");
			return ;
		}
	}
	
	
	public void dequeue() {
		try {
		if(front==rear) {
			System.out.println("queue is empty");
			return;
		}
		else {
			for(int i=0;i<rear-1;i++) {
				arr[i]=arr[i+1];
			}
			if(rear<capacity)
				arr[rear]=0;
			
			rear--;
			return;
		}
	}
		catch(Exception e) {
			System.out.println("index out of bound exception");
			return ;
		}
	}
	
	
	public void peek() {
		try {
		if(front ==rear) {
			System.out.println("queue is empty");
			return;
		}
		System.out.println("peek element of queue is "+ arr[front]);
	}
		catch(Exception e) {
			System.out.println("index out of bound exception");
			return ;
		}
	}
	
	
	public boolean contains(int x) {
		if(front ==rear) {
			System.out.println("queue is empty ");
			return false;
		}
		for(int i=front;i<rear;i++) {
			if(arr[i]==x)
				return true;
		}
		return false;
	}
	
	
	public void sort() {
		try {
		int n=rear;
		for(int i=front;i<n;i++) {
			for(int j=front;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		}catch(Exception e) {
			System.out.println("index out of bound exception");
			return;
		}
	}
	
	
	public int center() {
		try {
		if(front==rear)
			return -1;
		int middle=size()/2;
		return arr[middle];
		}catch(Exception e) {
			System.out.println("index out of bound exception");
			return Integer.MIN_VALUE;
		}
	}
	
	
	public void reverse() {
		try {
		int i=front;
		int j=rear-1;
		while(i<j) {
			int temp=arr[i];
			arr[i++]=arr[j];
			arr[j--]=temp;
		}
		}catch(Exception e) {
			System.out.println("index out of bound exception");
			return ;
		}
	}
	
	
	public void print() {
		try {
		if(front ==rear) {
			System.out.println("queue is empty");
			return;
		}
		for(int i=front;i<rear;i++) {
			System.out.print(arr[i]+ " ");
		}
		}catch(Exception e) {
			System.out.println("index out of bound exception");
			return ;
		}
	}

	public static void main(String[] args) {
		Queues q=new Queues(8);
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		q.enqueue(6);
		q.enqueue(7);
		//q.enqueue(8);
		q.dequeue();
		q.dequeue();
		//q.sort();
		//q.reverse();
		q.peek();
		System.out.println(q.contains(5));
		System.out.println("size of the queue is " +q.size());
		System.out.println("the center element of the queue is "+q.center());
		System.out.println("------------------");
		q.print();

	}

}
