/**
 * 
 */
package com.x.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class RemoveDuplicatesFromLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicatesFromLinkedList removeDuplicatesFromLinkedList = new RemoveDuplicatesFromLinkedList();
		Node node = new Node(2);
		node.nextNode = new Node(2);
		node.nextNode.nextNode = new Node(5);
		node.nextNode.nextNode.nextNode = new Node(3);
		node.nextNode.nextNode.nextNode.nextNode=new Node(4);
		node.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(1);
		node.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(4);
		removeDuplicatesFromLinkedList.displayList(node);
		Node head = removeDuplicatesFromLinkedList.removeDuplicates(node);
		removeDuplicatesFromLinkedList.displayList(head);
		

	}
	
	private Node removeDuplicates(Node node) {
		if(node==null){
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Node next=node.nextNode;
		Node curr=node;
		Node temp;
		map.put(node.data, 1);
		while(next!=null){
			int data=next.data;
			if(map.containsKey(data)){
				curr.nextNode=next.nextNode;
				temp=next;
				next=next.nextNode;
				temp.nextNode=null;
				
			}else{
				map.put(node.data, 1);
				curr=next;
				next=next.nextNode;
			}
		}
		return node;
		
		
	}

	private void displayList(Node node) {
		if(node==null){
			return;
		}
		Node temp = node;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.nextNode;
		}
		System.out.println();
		
	}

	private static class Node{
		private Node nextNode;
		private Integer data;
		
		public Node(Integer data){
			this.data = data;
			nextNode = null;
		}
	}

}
