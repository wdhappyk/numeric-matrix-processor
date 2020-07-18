import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double a = scanner.nextDouble();
        final double b = scanner.nextDouble();
        final double result = Math.pow(a, b);
        System.out.println(result);
    }
}