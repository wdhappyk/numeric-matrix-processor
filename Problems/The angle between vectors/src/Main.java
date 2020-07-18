import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Vector a = new Vector(scanner.nextInt(), scanner.nextInt());
        final Vector b = new Vector(scanner.nextInt(), scanner.nextInt());
        System.out.println(Vector.angleBetween(a, b));
    }
}

class Vector {
    int x;
    int y;

    static double angleBetween(Vector a, Vector b) {
        final double cos = (a.x * b.x + a.y * b.y) / (a.length() * b.length());
        return Math.toDegrees(Math.acos(cos));
    }

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.hypot(this.x, this.y);
    }

}