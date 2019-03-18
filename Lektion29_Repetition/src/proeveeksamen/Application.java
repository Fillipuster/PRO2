package proeveeksamen;

public class Application {

	public static void main(String[] args) {
		BinaryTree<String> three_one = new BinaryTree<>("2");
		BinaryTree<String> three_two = new BinaryTree<>("4");
		BinaryTree<String> two_one = new BinaryTree<>("+", three_one, three_two);
		BinaryTree<String> two_two = new BinaryTree<>("7");
		BinaryTree<String> two_three = new BinaryTree<>("3");
		BinaryTree<String> two_four = new BinaryTree<>("8");
		BinaryTree<String> one_one = new BinaryTree<>("*", two_one, two_two);
		BinaryTree<String> one_two = new BinaryTree<>("+", two_three, two_four);
		BinaryTree<String> root = new BinaryTree<>("+", one_one, one_two);
		
		System.out.println("Printout:");
		root.print();
		System.out.println();
		
		System.out.println("Count of '*':");
		System.out.println(root.countElements("+"));
		System.out.println();
	
		System.out.println("Value:");
		System.out.println(root.value());
		System.out.println();
	}

}
