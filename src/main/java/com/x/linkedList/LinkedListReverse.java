/**
 * 
 */
package com.x.linkedList;

/**
 * @author sparida
 *
 */
public class LinkedListReverse {
	
	private static Node head;
	

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedListReverse linkedListReverse = new LinkedListReverse();
		linkedListReverse.createList(5);
		linkedListReverse.printList(head);
		//linkedListReverse.reverseList(head);
		linkedListReverse.reverseListIterativeWay(head);
		//linkedListReverse.printList(head);
		

	}
	
	private void reverseListIterativeWay(Node head) {
		Node curr = null;
		Node pre = null;
		Node next = head;
		while(next!=null){
			curr = next;
			next = curr.nextNode;
			curr.setNextNode(pre);
			pre=curr;
		}
		head=curr;
		LinkedListReverse linkedListReverse = new LinkedListReverse();
		linkedListReverse.printList(head);
		
	}

	private void reverseList(Node curr) {
		if(curr == null){
			return;
		}
		
		if(curr.getNextNode()==null){
			this.head = curr;
			return;
		}
		
		reverseList(curr.nextNode);
		curr.getNextNode().setNextNode(curr);
		curr.setNextNode(null);
		
		
	}

	private void printList(Node head) {
		if(head==null){
			return;
		}
		Node temp = head;
		
		while(temp!=null){
			System.out.print(temp.getData()+"->");
			temp = temp.getNextNode();
		}
		System.out.println("null");
		
	}

	private void createList(int n) {
		
		if(n<1){
			return;
		}
		Node temp = null;
		int i =1;
		while(i<=n){
			Node node = new Node(i);
			if(this.head==null){
				this.head=node;
				temp = node;
			}else{
				temp.setNextNode(node);
				temp = node;
			}
			i++;
		}
	}

	class Node{
		private Node nextNode;
		private Integer data;
		
		public Node(Integer data){
			this.data = data;
		}
		
		public Node(Node nextNode, Integer data){
			this.data = data;
			this.nextNode = nextNode;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [nextNode=" + nextNode + ", data=" + data + "]";
		}
		
		
	}

}
