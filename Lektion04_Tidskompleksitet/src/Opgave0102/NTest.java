package Opgave0102;

public class NTest {

    public static int method1(long n) {
        int result = 0;
        for (long i = 0; i < n; i++) {
            for (long j = 1; j < n; j = j * 2) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long n = Integer.MAX_VALUE;
        System.out.println("INT : " + n);
        System.out.println("RES : " + method1(n)); // 2147483617
    }

}
