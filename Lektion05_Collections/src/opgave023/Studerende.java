package opgave023;

import java.util.ArrayList;
import java.util.List;

public class Studerende {
    private int studieNr;
    private String navn;
    private List<Integer> karakterer = new ArrayList<>();

    public Studerende(int studieNr, String navn) {
        this.studieNr = studieNr;
        setNavn(navn);
    }

    public double gennemsnit() {
        double sum = 0;
        for (int k : karakterer) {
            sum += k;
        }

        return sum / karakterer.size();
    }

    public int getStudieNr() {
        return studieNr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void addKarakter(int k) {
        karakterer.add(k);
    }

    public List<Integer> getKarakterer() {
        return new ArrayList<>(karakterer);
    }

    @Override
    public String toString() {
        return navn + " (" + studieNr + ")";
    }

}
