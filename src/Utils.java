import java.util.Scanner;

public class Utils {
    static final Scanner scanner = new Scanner(System.in);

    public static void print(String sentence) {
        System.out.println(sentence);
    }
    public static double doubleScanner() {
        return scanner.nextDouble();
    }

    public static int intScanner() {
        return scanner.nextInt();
    }

    public static void notImplemented() {
        print("Not implemented yet.");
    }

}
