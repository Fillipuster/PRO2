package Opgave01;

import java.util.ArrayList;

public class Sum {

    public static int sumList(ArrayList<Integer> list) {
        return doSumList(list, 0, list.size() - 1);
    }

    public static int doSumList(ArrayList<Integer> list, int low, int high) {
        if (low == high) {
            return list.get(low);
        }

        int m = (low + high) / 2;
        return doSumList(list, low, m) + doSumList(list, m + 1, high);
    }

    public static void main(String[] args) {
        int[] numArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            nums.add(numArr[i]);
        }

        System.out.println(sumList(nums));
    }

}
