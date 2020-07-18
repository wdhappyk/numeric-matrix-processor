import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String sourceDate = scanner.next();
        final String formattedDate = formatDate(sourceDate);
        System.out.println(formattedDate);
    }

    private static String formatDate(String sourceDate) {
        String[] info = sourceDate.split("-");
        return info[1] + "/" + info[2] + "/" + info[0];
    }
}