import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();

        int maxValue = scanner.nextInt();
        int maxValueRow = 0;
        int maxValueCol = 0;

        for (int row = 0; row < rows; ++row) {
            for (int col = row != 0 ? 0 : 1; col < cols; ++col) {
                final int value = scanner.nextInt();
                if (value <= maxValue) {
                    continue;
                }
                maxValue = value;
                maxValueRow = row;
                maxValueCol = col;
            }
        }

        System.out.print(maxValueRow + " " + maxValueCol);
    }
}