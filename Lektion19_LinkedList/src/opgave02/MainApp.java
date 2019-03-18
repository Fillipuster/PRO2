package opgave02;

public class MainApp {

	public static void main(String[] args) {
		SortedDoublyLinkedList<String> list = new SortedDoublyLinkedList<String>();
		
		System.out.println("Adding John...");
		list.addElement("John");
		System.out.println("\t" + list);
		System.out.println("Adding Adam...");
		list.addElement("Adam");
		System.out.println("\t" + list);
		System.out.println("Adding Xavier...");
		list.addElement("Xavier");
		System.out.println("\t" + list);
		System.out.println("Adding Bob...");
		list.addElement("Bob");
		System.out.println("\t" + list + "\n");
		System.out.println("Element count : " + list.countElements() + "\n");
		System.out.println("Removing John : " + list.removeElement("John"));
		System.out.println("\t" + list + "\n");
		System.out.println("Removing first : " + list.removeFirst());
		System.out.println("\t" + list + "\n");
		System.out.println("Removing last : " + list.removeLast());
		System.out.println("\t" + list + "\n");		
		list = new SortedDoublyLinkedList<String>();
		System.out.println("Count of empty list : " + list.countElements());
	}

}
