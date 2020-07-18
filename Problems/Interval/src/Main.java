import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final boolean belong = n > -15 && n <= 12 || n > 14 && n < 17 || n >= 19;
        System.out.print(belong ? "True" : "False");
    }
}