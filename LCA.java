import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	public int data;
	public TreeNode parent;
	public List<TreeNode> children;
	public TreeNode(int data){
		this.data = data;
	}
}
public class LCA {
	
	public static int lot(TreeNode root, int v1, int v2){
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode tmp = queue.poll();
			System.out.println(tmp.data);
			// iterate thru the children
			
		}
		return 0;
	}
	public static void main(String args[]){
		/*TreeNode root = new TreeNode(4);
		root.children.add(new TreeNode(2));
		root.children.add(new TreeNode(7));
		root.children.
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode (3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		lot(root);*/
	}
}
