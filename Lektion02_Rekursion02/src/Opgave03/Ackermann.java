package Opgave03;

public class Ackermann {

    public static int ack(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (x == 0) {
            return y + 1;
        }

        if (y == 0) {
            return ack(x - 1, 1);
        }

        return ack(x - 1, ack(x, y - 1));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("Ackermann of " + i + " & " + j + " is: " + ack(i, j));
            }
        }
    }

}
