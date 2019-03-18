package BST;

public class App {
	
	public static void pPrint(String msg, Object value) {
		System.out.println("\n" + msg);
		System.out.println("-> " + value);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> opg2 = new BinarySearchTree<>();
		opg2.add(45);
		opg2.add(22);
		opg2.add(77);
		opg2.add(11);
		opg2.add(30);
		opg2.add(90);
		opg2.add(15);
		opg2.add(25);
		opg2.add(88);
		
		opg2.print();
		
		pPrint("findMax()", opg2.findMax());
		pPrint("removeMin()", opg2.removeMin());
		System.out.println();
		
		opg2.print();
		
		for (int i = 0; i < 9; i++) {
			pPrint("removeMin()", opg2.removeMin());
			opg2.print();
		}
		
		System.out.println("Done!");
	}

}
