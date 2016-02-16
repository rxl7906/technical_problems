import java.util.Stack;
// Implement a Queue using Stacks
public class QueueUsingStacks {
	static Stack<Integer> stk1 = new Stack<Integer>();
	
	// implement enqueue
	static void enqueue(int i) {
		stk1.push(i);
	}
	
	// implement dequeue
	static int dequeue(){
		Stack<Integer> stk2 = new Stack<Integer>();
		int i;
		while(!stk1.isEmpty()){
			i = stk1.pop();
			stk2.push(i);
		}
		int d = stk2.pop();
		int j;
		while(!stk2.isEmpty()){
			j = stk2.pop();
			stk1.push(j);
		}
		return d;
	}
	
	public static void main(String args[]){
		enqueue(3);
		enqueue(4);
		enqueue(5);
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	}
}
