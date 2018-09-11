package P12_8;

import java.util.Arrays;

public class Main {

    public static int getHighest(int[] ints) throws LovelyException {
        return getHighestMax(ints, 0);
    }

    public static int getHighestMax(int[] ints, int max) throws LovelyException {
        if (ints.length < 0) {
            throw new LovelyException();
        }

        if (ints.length == 0) {
            return max;
        }

        if (ints[ints.length - 1] > max) {
            max = ints[ints.length - 1];
        }

        int[] newInts = Arrays.copyOfRange(ints, 0, ints.length - 1);
        return getHighestMax(newInts, max);
    }

    public static void main(String[] args) {

        int[] ints = { 3, 7, 2, 0, 8, 2, 9, 1 };
        try {
            System.out.println(getHighest(ints));
        } catch (LovelyException e) {
            e.printStackTrace();
        }

    }

}
