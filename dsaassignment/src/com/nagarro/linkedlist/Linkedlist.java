package com.nagarro.linkedlist;

public class Linkedlist {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	
	
	
	public void insert(int newData) {
		try {
		Node new_node=new Node(newData);
		if(head==null) {
			head=new Node(newData);
			return;
		}
		new_node.next=null;
		Node last=head;
		while(last.next!=null) 
			last=last.next;
		last.next=new_node;
		return; 
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return;
		}
	}
	
	
	public void insertAtPosition(int data,int position) {
		try {
		Node node=new Node(data);
		node.next=null;
		if(head==null) {
			return;
		}
		else if(position==0) {
			node.next=head;
			head=node;
			return;
		}
		else {
			Node curr=head;
			for(int i=0;i<position-1;i++) {
				curr=curr.next;
			}
			node.next=curr.next;
			curr.next=node;
			return;
		}
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return;
		}
	}
	
	
	public void delete() {
		try {
		if(head==null)
			return;
		Node temp=head;
		Node prev=null;
		while(temp.next!=null) {
			prev=temp;
			temp=temp.next;
		}
		prev.next=null;
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return;
		}
	}
	
	
	public void deleteAtposition(int position) {
		try {
		if(head==null)
			return;
		Node temp=head;
		if(position==0) {
			head=temp.next;
			temp= null;
			return; 
		}
		for(int i=1;i<position-1;i++) {
			if(temp!=null)
				temp=temp.next;
		}
		if(temp==null||temp.next==null)
			return;
		Node nodeToDelete=temp.next;
		temp.next=temp.next.next;
		nodeToDelete=null;
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return;
		}
	}
	
	
	public int getlen() {
		try {
		if(head==null)
			return 0;
		int length=0;
		Node node=head;
		while(node!=null) {
			length++;
			node=node.next;
		}
		return length;
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return Integer.MIN_VALUE;
		}
	}
	
	
	public void center() {
		try {
		if(head==null)
			return;
		int len=getlen();
		Node temp=head;
		int middle=len/2;
		while(middle-->0) {
			temp=temp.next;
		}
		System.out.println("center of the linked list is "+ temp.data);
		}catch(Exception e) {
			return;
		}
	}
	
	
	public void reverse() {
		try {
		if(head==null)
			return;
		Node curr=head;
		Node prev=null;
		Node next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;	
		}
		head=prev;
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return;
		}
	}
	
	
	public void sortList() {
		try {
		if(head==null)
			return;
		Node current=head;
		Node index=null;
				int temp;
				while(current!=null) {
					index=current.next;
					while(index!=null) {
						if(current.data>index.data) {
							temp=current.data;
							current.data=index.data;
							index.data=temp;
						}
						index=index.next;
					}
					current=current.next;
					
				}
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return;
		}
	}
	
	
	public void print() {
		try {
		if(head==null)
			return;
		Node node =head;
		while(node!=null) {
			System.out.print(node.data+ " ");
			node=node.next;
		}
		System.out.println();
		}catch(Exception e) {
			System.out.println("Nullpointer exception");
			return;
		}
	}
	

	public static void main(String[] args) {
		Linkedlist list=new Linkedlist();
		System.out.println("insert a node ");
		list.insert(8);
		list.insert(9);
		list.insert(7);
		list.insert(4);
		list.insert(5);
		//list.insert(6);
		list.print();
		list.sortList();
		list.print();
		System.out.println("List after getting reversed ");
		list.reverse();
		list.print();
		System.out.println("length of the linkedlist is " +list.getlen());
		list.center();
		System.out.println("Insert a node at given position : ");
		list.insertAtPosition(4, 0);
		list.print();
		System.out.println("delete a node at given position");
		list.deleteAtposition(1);
		list.print();
		System.out.println("Delete a node ");
		list.delete();
		list.print();
		
		

	}

}
