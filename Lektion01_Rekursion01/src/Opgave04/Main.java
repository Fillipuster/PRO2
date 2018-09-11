package Opgave04;

public class Main {

    public static int sfd(int a, int b) {
        if (b <= a && a % b == 0) {
            return b;
        }

        if (a < b) {
            return sfd(b, a);
        } else {
            return sfd(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println(sfd(16, 20) + "\n");

        int big = 0;
        int bigI = 0;
        int bigJ = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                if (i == j || i / 2 == j || j / 2 == i) {
                    continue;
                }
                int sfd = sfd(i, j);
                if (sfd > big) {
                    big = sfd;
                    bigI = i;
                    bigJ = j;
                }
            }
        }

        System.out.println(bigI + ", " + bigJ);
        System.out.println(big);
    }

}
