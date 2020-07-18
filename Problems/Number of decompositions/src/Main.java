import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();

        decompose(n, n, "");
    }

    private static void decompose(int max, int remains, String path) {
        if (remains == 0) {
            System.out.println(path.trim());
            return;
        }

        for (int i = 1; i <= Math.min(remains, max); ++i) {
            decompose(i, remains - i, path + " " + i);
        }
    }

}