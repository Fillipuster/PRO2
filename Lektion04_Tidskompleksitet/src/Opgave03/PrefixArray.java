package Opgave03;

public class PrefixArray {

    public static double[] prefixAverageFast(double[] input) {
        double[] result = new double[input.length];
        double sum = input[0];
        result[0] = sum;

        for (int i = 1; i < result.length; i++) {
            sum += input[i];
            result[i] = sum / (i + 1);
        }

        return result;
    }

    public static double[] prefixAverageSlow(double[] input) {
        double[] result = new double[input.length];

        for (int i = 0; i < input.length; i++) {
            double sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += input[j];
            }

            result[i] = sum / (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        double[] nums = { 5, 10, 5, 6, 4, 9, 8 };
        double[] result = prefixAverageFast(nums);

        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                System.out.println(result[i]);
            } else {
                System.out.print(result[i] + ", ");
            }
        }
    }

}
