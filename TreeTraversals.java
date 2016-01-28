import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	public int data;
	public Node left;
	public Node right;
	public Node(int data){
		this.data = data;
	}
}
public class TreeTraversals {
	// recursion
	/*public static void preorder(Node root){
		if(root != null){
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}*/
	// no recursion
	public static int preorder(Node root){
		int sum = 0;
		// create empty stack and push root to it
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		// pop all items one by one
		// 1) print it
		// 2) push its right child
		// 3) push its left child
		while(!stack.empty()){
			Node node = stack.pop();
			System.out.println(node.data);
			sum += node.data;
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
		return sum;
	}
	
	// recursion
	/*public static void inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}*/
	// no recursion
	public static int inorder(Node root){
		int sum = 0;
		Node cur = root;
		Stack<Node> s = new Stack<Node>();
		boolean done = false;
		while(!done){
			//System.out.println(cur.data);
			if(cur != null){
				//System.out.println(cur.data);
				s.push(cur);
				cur = cur.left;
			} else {
				if(!s.isEmpty()){
					cur = s.pop();
					sum += cur.data;
					System.out.println(cur.data);
					cur = cur.right;
				} else {
					done = true;
				}
			}
		}
		return sum;
	}
	
	// recursion
	public static void postorder(Node root){
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}
	
	// recursion
	/*public static int height(Node root){
		if(root == null){
			return 0;
		} else {
			return Math.max(height(root.left)+1, height(root.right)+1);
		}
	}*/
	// iterative
	public static int height(Node root){
		if(root == null){
			return 0;
		}
		int height = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(true){
			int nodeLevelCount = q.size();
			if(nodeLevelCount == 0){
				return height;
			}
			height++;
			while(nodeLevelCount > 0){
				Node tmp = q.poll();
				if(tmp.left != null){
					q.add(tmp.left);
				}
				if(tmp.right != null){
					q.add(tmp.right);
				}
				nodeLevelCount--;
			}
		}
	}
	
	static int getNodeLevel(Node root, int data){
		return getLevel(root, data, 1);
	}
	
	// get level of node in binary tree
	static int getLevel(Node root, int data, int level){
		if(root == null){
			return 0;
		}
		if(root.data == data){
			return level;
		}
		int downlevel = getLevel(root.left, data, level+1);
		if(downlevel != 0){
			return downlevel;
		}
		downlevel = getLevel(root.right, data, level+1);
		return downlevel;
	}

	/*public static void lot(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node tmp = queue.poll();
			System.out.println(tmp.data);
			if(tmp.left != null){
				queue.add(tmp.left);
			}
			if(tmp.right != null){
				queue.add(tmp.right);
			}
		}
	}*/
	// print binary tree in level order 
	static void lot(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node tmp = queue.poll();
			System.out.println(tmp.data);
			if(tmp.left != null){
				queue.add(tmp.left);
			}
			if(tmp.right != null){
				queue.add(tmp.right);
			}
		}
	}
	
	// binary search tree
	/*public static Node lca(Node root, int v1, int v2){
		while(root != null){
			if(v1 < root.data && v2 < root.data){
				root = root.left;
			} else if(v1 > root.data && v2 > root.data){
				root = root.right;
			} else break;
		}
		return root;
	}*/
	
	// binary tree
	static Node lca(Node root, int a, int b){
		if (root == null) {
	        return null;
	    }
	    
	    if (root.equals(a) || root.equals(b)) { 
	        // if at least one matched, no need to continue
	        // this is the LCA for this root
	        return root;
	    }

	    Node l = lca(root.left, a, b);
	    Node r = lca(root.right, a, b);

	    if (l != null && r != null) {
	    	return root;  // nodes are each on a seaparate branch
	    }

	    // either one node is on one branch, 
	    // or none was found in any of the branches
	    return l != null ? l : r;
	}
	
	public static void main(String args[]){
		// binary tree example
		/*Node root = new Node(7);
		root.left = new Node(2);
		root.right = new Node(1);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.right.left = new Node(9);
		root.right.right = new Node(2);*/
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(11);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);
		System.out.println(lca(root, 7,9));
		/*Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.left = new Node(6);*/
		/*Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node (3);
		root.right.left = new Node(6);
		root.right.right = new Node(8);*/
		//preorder(root);
		//System.out.println(lca(root,1,3).data);
		//System.out.println(getNodeLevel(root, 8));
		//inorder(root);
		//postorder(root);
		//System.out.println(inorder(root));
		//lot(root);
		//System.out.println(height(root));
		//System.out.println(height(root));
	}
}
