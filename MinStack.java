import java.util.Stack;

// design a min stack class that supports push, pop, top and retrieving
// the minimum element in constant time
public class MinStack {
	private static Stack<Integer> s;
	private static Stack<Integer> minS;
	// push element
	static void push(int i){
		System.out.println(i);
		if(i < minS.peek()){
			minS.add(i);
		}
		s.add(i);
	}
	static void pop(){
		if(s.peek() == minS.peek()){
			s.pop();
			minS.pop();
		}
		s.pop();
	}
	// get min from stack
	public static void getMin(){
		/*Stack<Integer> stk = new Stack<Integer>();
		int val = s.pop();
		stk.add(val);
		while(!stk.isEmpty()){
			int ele = s.pop();
			if(ele > stk.peek()){
				stk.push(ele);
			}
		}
		return stk.peek();*/
		System.out.println(minS.peek());
	}
	public static void main(String args[]){
		s = new Stack<Integer>();
		minS = new Stack<Integer>();
		s.push(4);
		s.push(1);
		s.push(7);
		s.push(3);
		//getMin();
		System.out.println(minS.peek());
	}
}
