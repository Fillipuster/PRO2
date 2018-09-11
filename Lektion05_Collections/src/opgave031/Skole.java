package opgave031;

import java.util.Set;
import java.util.TreeSet;

public class Skole {
    private String navn;
    private Set<Studerende> studerende = new TreeSet<>();

    public Skole(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return this.navn;
    }

    public void addStuderende(Studerende s) {
        studerende.add(s);
    }

    public void removeStuderende(Studerende s) {
        studerende.remove(s);
    }

    public double gennemsnit() {
        double sum = 0;
        for (Studerende s : studerende) {
            sum += s.gennemsnit();
        }

        return sum / studerende.size();
    }

    public Studerende findStuderende(int studieNr) {
        Studerende found = null;
        for (Studerende s : studerende) {
            if (s.getStudieNr() == studieNr) {
                found = s;
                break;
            }
        }

        return found;
    }

    @Override
    public String toString() {
        String result = navn + ":\n\t";
        for (Studerende s : studerende) {
            result += s.toString() + "\n\t";
        }

        return result;
    }
}
