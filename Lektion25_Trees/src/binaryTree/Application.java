package binaryTree;

import binaryTree.BinaryTree.Order;

public class Application {

	private static void pPrint(String msg, Object result) {
		System.out.println(msg);
		System.out.println("-> " + result.toString() + "\n");
	}
	
	public static void main(String[] args) {
		// Test of size method (Opgave 1);
		pPrint("Size of empty tree:", new BinaryTree<>().size());
		pPrint("Size of root-only tree:", new BinaryTree<>("Hans").size());

		BinaryTree<Integer> t0 = new BinaryTree<>(42);
		for (int i = 0; i < 20; i++) {
			t0 = new BinaryTree<Integer>(i, t0, new BinaryTree<>(-i));
		}
		
		pPrint("Size of looped tree:", t0.size());
		pPrint("Height of looped tree:", t0.height());
		
		// Opgave 2-1;
		BinaryTree<Integer> t31 = new BinaryTree<Integer>(11, null, new BinaryTree<>(15));
		BinaryTree<Integer> t32 = new BinaryTree<Integer>(30, new BinaryTree<>(25), null);
		BinaryTree<Integer> t33 = new BinaryTree<Integer>(90, new BinaryTree<>(88), null);
		
		BinaryTree<Integer> t21 = new BinaryTree<Integer>(22, t31, t32);
		BinaryTree<Integer> t22 = new BinaryTree<Integer>(77, null, t33);
		
		BinaryTree<Integer> t1 = new BinaryTree<Integer>(45, t21, t22);
		
//		t1 = new BinaryTree<Integer>(69, t1, null);
		
		// Opgave 2-2;
		pPrint("Size of opg2 tree:", t1.size());
		pPrint("Height of opg2 tree:", t1.height());
		
		System.out.println("Printing opg2 tree in-order...");
		t1.print(Order.IN);
		System.out.println();
		
		System.out.println("Printing opg2 tree pre-order...");
		t1.print(Order.PRE);
		System.out.println();
		
		System.out.println("Printing opg2 tree post-order...");
		t1.print(Order.POST);
		System.out.println();
		
		pPrint("Sum of opg2 tree:", t1.sum());
		pPrint("Average of opg2 tree:", t1.avg());
	}

}
