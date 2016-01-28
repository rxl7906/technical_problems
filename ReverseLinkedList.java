
public class ReverseLinkedList {
	private class Node{
		private int data;
		private Node next = null;
		public Node(int data){
			this.data = data;
		}
	}
	private Node head;
	
	private static void printLinkedList(Node head){
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
	}
	private void insert(int data){
		while(head != null){
			head = head.next;
		}
		head = new Node(data);
	}
	public static void main(String args[]){
		ReverseLinkedList list = new ReverseLinkedList();
		list.insert(4);
		list.insert(3);
		list.insert(9);
		list.insert(6);
		printLinkedList(list.head);
		

	}
}
