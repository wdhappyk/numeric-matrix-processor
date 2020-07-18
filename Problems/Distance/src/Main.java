import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double distance = scanner.nextDouble();
        final double hours = scanner.nextDouble();
        final double averageSpeed = distance / hours;
        System.out.print(averageSpeed);
    }
}