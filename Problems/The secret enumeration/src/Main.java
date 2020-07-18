public class Main {

    public static void main(String[] args) {
        final Secret[] values = Secret.values();
        int count = 0;

        for (Secret value : values) {
            if (value.name().startsWith("STAR")) {
                count++;
            }
        }

        System.out.print(count);
    }
}

// At least two constants start with STAR
enum Secret {
    STAR, CRASH, START;
}
