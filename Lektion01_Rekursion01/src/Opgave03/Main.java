package Opgave03;

public class Main {

    public static int power(int n, int p) {
        if (p == 0) {
            return 1;
        }

        return power(n, p - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }

}
