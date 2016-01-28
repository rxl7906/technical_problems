
public class TernaryTree {
	private class Node {
		private int val;
		private Node left = null;
		private Node right = null;
		private Node mid = null;

		public Node(int val) {
			this.val = val;
		}
	}
	private Node root;

	public static void main(String[] args) {
		TernaryTree t = new TernaryTree();
		t.insert(7);
		t.delete(7);
		t.insert(10);
		t.insert(12);
		t.insert(23);
		t.insert(11);
		t.insert(4);

		// t.insert(50); t.insert(75); t.insert(25); t.insert(25); t.insert(90);
		// t.insert(60); t.delete(7);
		// t.insert(7); t.insert(10); t.insert(10); t.delete(10);
		t.display(t.root);
	}

	private void display(Node root2) {
		// TODO Auto-generated method stub
		if (root2 != null) {
			display(root2.left);
			display(root2.mid);
			System.out.println(root2.val);
			display(root2.right);
		}
	}

	/*
	 * Please complete this method. Inserts val into the tree.
	 */
	public void insert(int val) {
		Node newNode = new Node(val);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (val < focusNode.val) {
					focusNode = focusNode.left;
					if (focusNode == null) {
						parent.left = newNode;
						return;
					}
				} else if (val == focusNode.val) {
					focusNode = focusNode.mid;
					if (focusNode == null) {
						parent.mid = newNode;
						return;
					}
				} else {
					focusNode = focusNode.right;
					if (focusNode == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	/*
	 * Please complete this method. Deletes only one instance of val from the
	 * tree. If val does not exist in the tree, do nothing.
	 */
	/*
	 * public void delete(int val) { Node focusNode = root; Node parent = null;
	 * char direction = ' '; while(focusNode.val != val) { parent = focusNode;
	 * if(val < focusNode.val) { focusNode = focusNode.left; direction = 'l'; }
	 * else if(val == focusNode.val) { focusNode = focusNode.mid; direction =
	 * 'm'; } else { focusNode = focusNode.right; direction = 'r'; } }
	 * if(focusNode != null) {
	 * 
	 * if(focusNode.mid != null) { if(direction == 'r') { parent.right =
	 * focusNode.mid; } else if(direction == 'm') { parent.mid = focusNode.mid;
	 * } else if(direction == 'l') { parent.left = focusNode.mid; } } else
	 * if(focusNode.right != null) { if(direction == 'r') { parent.right =
	 * focusNode.right; } else if(direction == 'm') { parent.mid =
	 * focusNode.right; } else if(direction == 'l') { parent.left =
	 * focusNode.right; } } else { if(direction == 'r') { parent.right =
	 * focusNode.left; } else if(direction == 'm') { parent.mid =
	 * focusNode.left; } else if(direction == 'l') { parent.left =
	 * focusNode.left; } } } }
	 */

	public void delete(int val) {
		if (root == null) {
			return;
		} else
			root = delete(root, val);
	}

	public Node delete(Node root, int val) {
		if (root == null)
			return root;
		else if (val < root.val)
			root.left = delete(root.left, val);
		else if (val > root.val)
			root.right = delete(root.right, val);
		else {
			if (root.val == val && root.left == null && root.right == null) {
				root = null;
			}
			// Found at mid
			else if (root.mid != null) {
				Node parent = root;
				while (root.mid != null) {
					parent = root;
					root = root.mid;
				}
				parent.mid = null;
				return parent;
			} else {
				// Leaf node
				if (root.left == null && root.right == null) {
					root = null;
				}
				// No left child
				else if (root.left == null) {
					Node temp = root;
					root = root.right;
					temp = null;
				}
				// No right child
				else if (root.right == null) {
					Node temp = root;
					root = root.left;
					temp = null;
				}
				// 2 children - Min element in right subtree
				else {
					Node temp = FindMin(root.right);
					root.val = temp.val;
					root.right = delete(root.right, temp.val);
				}
			}
		}
		return root;
	}

	public Node FindMin(Node root) {
		while (root.left != null)
			root = root.left;
		return root;
	}
}
