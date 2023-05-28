package com.dxc.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTree {
	 static class Node {
		 int data;
		 Node left;
		 Node right;
		 
		 Node(int data){
			 
			 this.data=data;
			 this.left=null;
			 this.right=null;
		 }
		 
		 
		}
	 
	 public static class BinaryTreeSetter{
		 static int idx=-1;
		 public static Node buildTree(int [] nodes) {
			 
			 idx++;
			 
			 if(nodes[idx]==-1) {
				 return null;
				 
			 }
			 
			 
			 Node newNode=new Node(nodes[idx]);
			 
			 newNode.left= buildTree(nodes);
			 newNode.right=buildTree(nodes);
			 
			 
			 return newNode;
		 }
	
		 }
		 
		 
		 
	 
	 
	 static double  power(int num, int power) {
		 
		 int product=1;
		
		 
		
			
			 for (int i = 0; i < power; i++) {
				 
				 
				 
					product =product * num;
				}
				 return product;
		
		 
		
		 
	 }
	 
	 public static void main(String[] args) {
//		int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//		BinaryTreeSetter s=new BinaryTreeSetter();
//		 Node root=s.buildTree(nodes);
//		 System.out.println(root.data);
		 
		 
		 int x=2;
		 int power=-2;
		double z= power(x,power);
		 
		 
		 System.out.println(z);
		 
	
		 String s="I am Pratik ";
		 
		 
		String [] split= s.split(" ");
		 
		System.out.println(split[split.length-1].length()); 
		 
		
//		Map<Integer, List<Integer>>  —> Add all the values for which key of map is even
		//1, {1,2,3}, 2{4,5,6}
		
		
	
		
		
		
		
		Map<Integer,List<Integer>>  map= new HashMap<Integer,List<Integer>>();
		
	map.put(1, Arrays.asList(1,2,3));
	map.put(2, Arrays.asList(1,2,3));
	map.put(3, Arrays.asList(1,2,3));
	map.put(4, Arrays.asList(1,2,3));
		
		
	Integer sum=	map.entrySet().stream().filter(e->e.getKey()%2==0).flatMap(e-> e.getValue().stream()).reduce(0,(a,b)->a+b);
		
		 System.out.println(sum);
		 
		 
		 int arr[]= {1 ,5 ,4, 2, 8};
		 
		 
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				
			}
			
		} 
		 
		 
		System.out.println(Arrays.toString(arr));
		 
		 
		 
	}
	
	
}
