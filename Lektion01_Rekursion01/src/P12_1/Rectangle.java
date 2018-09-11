package P12_1;

public class Rectangle {

    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        if (width < 1) {
            return 0;
        }

        if (width == 1) {
            return height;
        }

        return new Rectangle(width - 1, height).getArea() + height;
    }

}
