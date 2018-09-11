package opgave01;

import java.util.HashSet;
import java.util.Set;

public class HashSetTester {

    public static boolean hasX(Set<Integer> set, int x) {
        for (int i : set) {
            if (i == x) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(34);
        set.add(12);
        set.add(23);
        set.add(45);
        set.add(67);
        set.add(34);
        set.add(98);

        System.out.println(set);

        set.add(23);
        System.out.println(set); // You cannot have two of the same value in a HashSet;

        set.remove(67);
        System.out.println(set + "\n");

        System.out.println("HasX Collection\t" + set.contains(23));
        System.out.println("HasX Manual\t" + hasX(set, 23));
        System.out.println("Size\t\t" + set.size());
    }

}
