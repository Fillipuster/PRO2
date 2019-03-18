package binaryTree;

/**
 * A binary tree in which each node has two children.
 */
/**
 * @author Fillipuster
 *
 * @param <E>
 */
public class BinaryTree<E> {
	private Node root;
	
	enum Order {
		IN, PRE, POST;
	}

	/**
	 * Constructs an empty tree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructs a tree with one node and no children.
	 * @param rootData the data for the root
	 */
	public BinaryTree(E rootData) {
		root = new Node();
		root.data = rootData;
		root.left = null;
		root.right = null;
	}

	/**
	 * Constructs a binary tree.
	 * @param rootData the data for the root
	 * @param left the left subtree
	 * @param right the right subtree
	 */
	public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
		root = new Node();
		root.data = rootData;
		if (left != null) {
			root.left = left.root;
		}
		if (right != null) {
			root.right = right.root;
		}
	}

	/**
	 * Checks whether this tree is empty.
	 * @return true if this tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Gets the data at the root of this tree.
	 * @return the root data
	 */
	public E data() {
		return root.data;
	}

	/**
	 * Gets the left subtree of this tree.
	 * @return the left child of the root
	 */
	public BinaryTree<E> left() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.left;
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 * @return the right child of the root
	 */
	public BinaryTree<E> right() {
		BinaryTree<E> result = new BinaryTree<>();
		result.root = root.right;
		return result;
	}

	/**
	 * Replaces the data of the root node.
	 * @param rootData the new data for the root
	 * @return the data previous in the root
	 */
	public E replace(E rootData) {
		E removed = root.data;
		root.data = rootData;
		return removed;
	}

	/**
	 * Calculates the size of the tree.
	 * @return the number of nodes in the tree
	 */
	// Can also be made with a counting integer;
	public int size() {
		return size(root);
	}

	// Private recursive helper method
	private int size(Node n) {
		if (n == null) return 0;
		
		int left = n.left != null ? size(n.left) : 0;
		int right = n.right != null ? size(n.right) : 0;
		
		return left + right + (n != null ? 1 : 0);
	}
	
	
	/**
	 * Calculates the height of the tree.
	 * @return the maximum distance from the root node to a leaf
	 */
	public int height() {
		return height(root);
	}
	
	private int height(Node n) {
		return Math.max(n.left != null ? height(n.left) : 0, n.right != null ? height(n.right) : 0) + 1;
	}
	
	
	/**
	 * Prints the contents of the tree.
	 * @param order the ordering of the printout. IN, PRE & POST
	 */
	public void print(Order order) {
		if (order.equals(Order.IN)) printIn(root);
		if (order.equals(Order.PRE)) printPre(root);
		if (order.equals(Order.POST)) printPost(root);
	}
	
	private void printIn(Node n) {
		if (n != null) {
			printIn(n.left);
			System.out.println(n.data);
			printIn(n.right);
		}
	}
	
	private void printPre(Node n) {
		if (n != null) {
			System.out.println(n.data);
			printPre(n.left);
			printPre(n.right);
		}
	}

	private void printPost(Node n) {
		if (n != null) {
			printPost(n.left);
			printPost(n.right);
			System.out.println(n.data);
		}
	}
	
	/**
	 * Calculates the sum of the tree.
	 * @return the sum of all the numbers in the tree
	 */
	public int sum() {
		return sum(root);
	}
	
	// Private recursive helper method;
	private int sum(Node n) {
		int val =  (int) n.data;
		return (n.left != null ? sum(n.left) : 0) + (n.right != null ? sum(n.right) : 0) + val;
	}
	
	/**
	 * Calculates the average of the tree.
	 * @return the average of all the values in the tree
	 */
	public double avg() {
		// Should probably be done in one big recursive run to avoid wasting resources;
		return sum() / size();
	}
	
	private class Node {
		public E data;
		public Node left;
		public Node right;
	}
}
