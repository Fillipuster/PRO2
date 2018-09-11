package Opgave03.src.fletning;

import java.util.ArrayList;

public class FletteSorteringMedTODO {

    // den metode der saetter fletningen i gang
    public void fletteSort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    // den rekursive metode der implementere del-loes og kombiner skabelonen
    private void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    // kombiner er realiseret ved fletteskabelonen
    private void merge(ArrayList<Integer> list, int low, int middle, int high) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>(list.subList(low, middle + 1));
        ArrayList<Integer> right = new ArrayList<>(list.subList(middle + 1, high + 1));

        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            int iVal = left.get(i);
            int jVal = right.get(j);

            if (iVal < jVal) {
                result.add(iVal);
                i++;
            } else {
                result.add(jVal);
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        for (int k = 0; k < result.size(); k++) {
            list.set(low + k, result.get(k));
        }
    }

}
