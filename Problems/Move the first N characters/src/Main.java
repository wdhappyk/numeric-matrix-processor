import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String word = scanner.next();
        final int n = scanner.nextInt();

        if (n >= word.length()) {
            System.out.println(word);
        } else {
            final String result = word.substring(n) + word.substring(0, n);
            System.out.println(result);
        }
    }
}