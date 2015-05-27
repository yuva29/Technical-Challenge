/**
 * Node structure, which stores the data and its child pointers
 * Assumptions:
 * 1. Implemented tri-nary tree accepts only integer data
 */
class Node {
	int data;
	Node left;
	Node right;
	Node mid;
	
	Node(int data){
		this(data, null, null, null);
	}
	Node(int data, Node left, Node right, Node mid){
		this.data = data;
		this.left = left;
		this.right = right;
		this.mid = mid;
	}
}

/**
 * Tri-nary Tree 
 * insert() : helper function for insert, visible to the user
 * delete() : helper function for delete, visible to the user
 * Private Functions: (not visible to the user/application program)
 * insert(root, data) : inserts the given data into the tree
 * delete(root, data) : deletes the given data from the tree 
 */
class TrinaryTree {
	private Node root;
	
	/**
	 * Helper function : calls the insert which inserts the data to tree
	 * @param data - data to be inserted into the tree
	 */
	void insert(int data) {
		System.out.println("INFO: Inserting data "+data+" into the tree");
		root = insert(root, data);
	}
	
	/**
	 * Inserts the given data into the tree
	 * @param root - root of the tri-nary tree
	 * @param data - data to be inserted into the tree
	 * @return - returns the root after inserting the given data 
	 */
	private Node insert(Node root, int data) {
		if(null == root) return new Node(data);
		if(root.data > data)
			root.left = insert(root.left, data);
		else if(root.data < data)
			root.right = insert(root.right,data);
		else
			root.mid = insert(root.mid, data);
		return root;
	}
	
	/**
	 * Helper function : calls the delete which deletes the data from the tree
	 * @param data - data to be deleted from the tree
	 * @throws Exception 
	 */
	void delete(int data) throws Exception { // gives the data to be deleted
			root = delete(root, data);
	}
	
	/**
	 * Deletes the given data from the tree
	 * @param root - root of the tri-nary tree
	 * @param data - data to be deleted from the tree
	 * @return - returns the root after deleting the given data
	 * @throws Exception 
	 */
	private Node delete(Node root, int data) throws Exception { 
		if(root == null) throw new Exception("ERROR : Invalid delete request. Data not found in the tree");
		if(root.data>data) root.left =  delete(root.left, data);
		else if(root.data<data) root.right = delete(root.right, data);
		else { // root.data == data
			if(null == root.left && null == root.right && null == root.mid) return null;
			else if(null != root.mid) root.mid = root.mid.mid;
			else { // deal like normal BST delete, inorder successor
				Node temp = root;
				if(null != temp.right){ // left most child of it
					temp = temp.right;
					while(null != temp.left) temp = temp.left;
					root.data = temp.data;
					root.right = delete(root.right, temp.data);
				} else if(null != root.left){
					root = root.left;
				}
			}
		}
		return root;
	}
	
	/**
	 * Helper function
	 */
	void inorderTraversal(){
		inorder(root);
	}
	
	/**
	 * Prints the inorder traversal of the given tree
	 * @param root - root of the tree
	 */
	private void inorder(Node root) { // left, mid, root and right
		if(null == root) {
			System.out.println("NULL");
			return;
		}
		if(null != root.left) inorder(root.left);
		if(null != root.mid) inorder(root.mid);
		System.out.print(root.data+",");
		if(null != root.right) inorder(root.right);
	}
}

/**
 * Class that invokes the tri-nary class and performs operations on it
 */
public class TrinaryTreeImpl {
	public static void main(String[] args) {
		test();	
	}
	private static void test() {
		System.out.println("Testcase 1 : Insertion of many elements and deletion of some left, right and middle childs");
		TrinaryTree  tT1 = new TrinaryTree();
		tT1.insert(10);
		tT1.insert(10);
		tT1.insert(7);
		tT1.insert(23);
		tT1.insert(45);
		tT1.insert(34);
		tT1.insert(46);
		tT1.insert(22);
		tT1.insert(15);
		tT1.insert(12);
		tT1.insert(18);
		tT1.insert(15);
		tT1.insert(45);
		
		System.out.println("Inorder traversal of the given tree : ");
		tT1.inorderTraversal();
		
		System.out.println("\nInorder traversal after delete(10): ");
		try {
			tT1.delete(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		tT1.inorderTraversal();
		
		System.out.println("\nInorder traversal after delete(22): ");
		try {
			tT1.delete(22);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		tT1.inorderTraversal();

		System.out.println("\nInorder traversal after delete(45): ");
		try {
			tT1.delete(45);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		tT1.inorderTraversal();
		
		System.out.println("\nInorder traversal after delete(4500): ");
		try {
			tT1.delete(4500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		tT1.inorderTraversal();			
		System.out.println();
		
		System.out.println("\nTestcase 2 : Delete from empty tree");
		TrinaryTree  tT2 = new TrinaryTree();
		try {
			tT2.delete(10);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("Inorder traversal of the tree ");
		tT2.inorderTraversal();
		System.out.println();
		
		System.out.println("\nTestcase 3 : Delete the data not available in the tree");
		TrinaryTree  tT3 = new TrinaryTree();
		tT3.insert(23);
		try {
			tT3.delete(10);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("Inorder traversal after delete(10): ");
		tT3.inorderTraversal();	
		System.out.println();
		
		System.out.println("\nTestcase 4 : Delete the root");
		TrinaryTree  tT4 = new TrinaryTree();
		tT4.insert(10);
		try {
			tT4.delete(10);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("Inorder traversal after delete(10) ");
		tT4.inorderTraversal();
		System.out.println();
	}
}