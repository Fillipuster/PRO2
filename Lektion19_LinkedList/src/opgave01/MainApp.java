package opgave01;

import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
		SortedLinkedList list = new SortedLinkedList();
		
		list.addElement("John");
		System.out.println(list);
		list.addElement("Adam");
		System.out.println(list);
		list.addElement("Xavier");
		System.out.println(list);
		list.removeElement("John");
		System.out.println(list);
		System.out.println("Count : " + list.countElements());
		list.removeElement("Xavier");
		System.out.println(list);
		
		System.out.println();
		
		System.out.println("Count of empty list : " + new SortedLinkedList().countElements());
		
		System.out.println();
		
		SortedLinkedList superList = new SortedLinkedList();
		
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			superList.addElement(String.valueOf((char)(rand.nextInt(93) + 33)));
		}
		System.out.println(superList);
		System.out.println("Count : " + superList.countElements());
		System.out.println("Count matches : " + (superList.countElements() == (superList.toString().length() / 3) ? "YES" : "NO"));
	}

}