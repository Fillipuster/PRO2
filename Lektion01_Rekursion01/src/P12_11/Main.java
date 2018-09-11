package P12_11;

public class Main {

    public static double sqrt(double x) {
        return guessSqrt(x, x / 2);
    }

    public static double guessSqrt(double x, double g) {
        if (x <= 0) {
            return 0;
        }

        if (Math.abs((g * g) - x) < 0.000001) {
            return g;
        }

        double guess = (g + x / g) / 2;

        return guessSqrt(x, guess);
    }

    public static void main(String[] args) {
        double g = sqrt(800);
        System.out.println("Guess Result : " + g);
        System.out.println("---||--- ^ 2 : " + g * g);
    }

}