package Opgave02;

import java.util.ArrayList;

public class Highest {

    public static int highest(ArrayList<Integer> list) {
        return doHighest(list, 0, list.size() - 1);
    }

    public static int doHighest(ArrayList<Integer> list, int low, int high) {
        if (low == high) {
            return list.get(low);
        }

        int m = (low + high) / 2;
        int resLow = doHighest(list, low, m);
        int resHigh = doHighest(list, m + 1, high);

        return (resLow > resHigh) ? resLow : resHigh;
    }

    public static void main(String[] args) {
        int[] numArr = { 1, 2, 3, 4, 10, 6, 7, 28, 8, 9, 5 };
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            nums.add(numArr[i]);
        }

        System.out.println(highest(nums));
    }

}
