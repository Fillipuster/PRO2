package opgave02;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Application {

    public static void main(String[] args) {
        ArrayedList<String> list = new ArrayedList<>();
        list.add("Banan");
        list.add("Æble");
        list.add("Tomat");
        list.add("Jordbær");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
        	System.out.println(iterator.next());
        }
        
        // Fail-fast (Udvidelse)
        System.out.println("\nTesting fail-fast...\n");
        
        iterator = list.iterator();
        System.out.println("Next -> " + iterator.next());
        System.out.println("Next -> " + iterator.next());
        list.add("TestEntry");
        try {
        	System.out.println("Performing list modification...");
        	System.out.println("Next -> " + iterator.next());        	
        } catch (ConcurrentModificationException e) {
        	System.err.println("Caught ConcurrentModificationException correctly!");
        }
    }

}
