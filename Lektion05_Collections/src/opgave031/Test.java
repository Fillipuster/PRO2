// Notice: The printout for the school is now ordered by name, because a TreeSet keeps itself ordered based on the Comparable implementation on Studerende - which is based on name.

package opgave031;

import java.util.Random;

public class Test {

    private static String[] names = { "Tom", "Oscar", "Peter", "Jonas", "Torben", "Michael", "Kennet", "Rasmus", "Lene",
            "Henrik", "Jacob", "Martin", "Frederik", "Morten", "Alexander", "Mikkel", "Daniel", "Thomas", "Mads",
            "Emil", "Hanne", "Ellen", "Elisabeth", "Ingeborg", "Julie", "Marie", "Maja", "Christine", "Christian",
            "Søren", "Lars", "Carsten" };

    private static int[] karakterer = { -3, 0, 2, 4, 7, 10, 12 };

    public static void main(String[] args) {
        Random r = new Random();

        Skole skole = new Skole("EAAA");

        for (int i = 0; i < 20; i++) {
            Studerende s = new Studerende(i + 1, names[r.nextInt(names.length - 1)]);
            for (int j = 0; j < r.nextInt(15) + 5; j++) {
                s.addKarakter(karakterer[r.nextInt(karakterer.length - 1)]);
            }
            skole.addStuderende(s);
        }

        System.out.println(skole);
        System.out.println("Karaktergennemsnit\t" + skole.gennemsnit());
        System.out.println();

        System.out.println("Attempting to find ID: 5...");
        System.out.println("Found: " + skole.findStuderende(5));
        System.out.println();

        System.out.println("Attempting to find ID: 25...");
        System.out.println("Found: " + skole.findStuderende(25));
        System.out.println();
    }

}