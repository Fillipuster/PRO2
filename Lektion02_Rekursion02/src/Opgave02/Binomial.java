package Opgave02;

public class Binomial {

    public static int binom(int m, int n) {
        if (m > n) {
            return 0;
        }

        if (m == 0 || m == n) {
            return 1;
        }

        return binom(m, n - 1) + binom(m - 1, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(binom(5, 2));
    }

}
