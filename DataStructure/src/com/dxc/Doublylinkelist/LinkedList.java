package com.dxc.Doublylinkelist;

public class LinkedList {

	Node head;

	public void add(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.prev=null;

		if (head == null) {
			head = node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			node.prev=n;
			n.next = node;
			
		}

	}

	public void display() {
		if (head == null) {
			System.out.println("Linked List is Empty");
		} else {
			Node n = head;
			while (n.next != null) {
				System.out.println(n.data);
				n = n.next;
			}
			System.out.println(n.data);
		}
	}

	public void remove(int index) {
		if (head == null) {
			System.out.println("Linked List is Empty");
		}
        
		else if (index==0) {
			head=head.next;
		}
          		
		else {
			Node n = head;
			Node n1=null;
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
			n1=n.next;
			n.next=n1.next;
		   
		}
	}

	public void insertAtFirst(int i) {
		Node node = new Node();
		node.data = i;
		node.next = head;
		head = node;

	}

	public void insertAtIndex(int i, int index) {

		Node node = new Node();
		node.data = i;
		node.next = null;
		if (head == null) {
			insertAtFirst(i);
		} else {

			Node n = head;
			for (int j = 0; j < index-1; j++) {

				n = n.next;

			}

			node.next = n.next;
			n.next = node;

		}

	}
	
	
	
	
	
	
	

}
