import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] numbers = {
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
                scanner.nextInt(),
        };

        for (int n : numbers) {
            System.out.println(n);
        }
    }
}