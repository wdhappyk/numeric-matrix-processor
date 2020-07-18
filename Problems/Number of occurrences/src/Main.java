import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String text = scanner.nextLine();
        final String expr = scanner.nextLine();
        int repeats = text.split(expr).length - 1;
        if (repeats == -1) {
            repeats = text.length() / expr.length();
        } else if (text.startsWith(expr) || text.endsWith(expr)) {
            repeats++;
        }
        System.out.println(repeats);
    }
}