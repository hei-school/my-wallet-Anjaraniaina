import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final Service service = new Service(0, new ArrayList<>(), "Ariary");


    public static void main(String[] args) {
        welcome();
        menu();
    }
    public static double doubleScanner() {
        return scanner.nextDouble();
    }

    public static int intScanner() {
        return scanner.nextInt();
    }

    public static void welcome(){
        Service.print("Hello! I'm your smart wallet\n" + "what do you want to do ?");
    }

    public static void menu() {
        Service.print(new StringBuilder()
                .append("1. Check your current balance.")
                .append("\n")
                .append("2. Take out money.")
                .append("\n")
                .append("3. Store money.")
                .append("\n")
                .append("4. Convert to another currency.")
                .append("\n")
                .append("5. Check your 5 latest transactions.")
                .append("\n")
                .append("6. Quit.")
                .toString());
        switch (intScanner()) {
            case 1 -> service.checkBalance();
            case 2 -> service.retrieveMoney();
            case 3 -> service.storeMoney();
            case 4 -> service.convertCurrency();
            case 5 -> service.history();
            case 6 -> quit();
            default -> menu();
        }
    }

    public static void quit() {
        Service.print("See you later !");
    };
}