import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static int scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void menu() {
        Service.print("Hello! I'm your smart wallet\n" + "what do you want to do ?");
        Service.print(new StringBuilder()
                .append("1. Check your current balance.")
                .append("\n")
                .append("2. Take out money.")
                .append("\n")
                .append("3. Store money.")
                .append("\n")
                .append("4. Epargne your money.")
                .append("\n")
                .append("5. Check your 5 latest transactions.")
                .append("\n")
                .append("6. Quit.")
                .toString());
        Service service = new Service();
        switch (scanner()){
            case 1: service.checkBalance();
                break;
            case 2: service.retrieveMoney();
            case 3: service.storeMoney();
            case 4: service.epargneMoney();
            case 5: service.history();
            case 6: quit();
        }
    }

    public static void quit() {
        Service.print("See you later !");
    };
}