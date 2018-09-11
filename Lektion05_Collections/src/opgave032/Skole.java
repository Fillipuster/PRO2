package opgave032;

import java.util.Map;
import java.util.TreeMap;

public class Skole {
    private String navn;
    private Map<Integer, Studerende> studerende = new TreeMap<>();

    public Skole(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return this.navn;
    }

    public void addStuderende(Studerende s) {
        studerende.put(s.getStudieNr(), s);
    }

    public void removeStuderende(Studerende s) {
        studerende.remove(s.getStudieNr());
    }

    public double gennemsnit() {
        double sum = 0;

        for (int i : studerende.keySet()) {
            sum += studerende.get(i).gennemsnit();
        }

        return sum / studerende.size();
    }

    public Studerende findStuderende(int studieNr) {
        Studerende found = null;
        for (int i : studerende.keySet()) {
            Studerende s = studerende.get(i);
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
        for (int i : studerende.keySet()) {
            result += studerende.get(i).toString() + "\n\t";
        }

        return result;
    }
}
