import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double celsiusTemperature = scanner.nextDouble();
        final double fahrenheitTemperature = celsiusTemperature * 1.8 + 32;
        System.out.print(fahrenheitTemperature);
    }
}