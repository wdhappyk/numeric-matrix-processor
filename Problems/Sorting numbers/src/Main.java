import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {
        for (int i = 1; i < numbers.length; ++i) {
            int x = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > x) {
                numbers[j] = numbers[j - 1];
                --j;
            }
            numbers[j] = x;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}