import java.util.ArrayList;

public class WalletService implements Compartment{
    public WalletService() {
    }

    static final MoneyService moneyService = new MoneyService(0, new ArrayList<>(), "Ariary");

    @Override
    public void precedentMenu() {
        Main.menu();
    }

    @Override
    public void menu() {
        Utils.print("What do you want to check ?");
        Utils.print(new StringBuilder()
                .append("1. CIN")
                .append("\n")
                .append("2. Money")
                .append("\n")
                .append("3. Bank cards")
                .append("\n")
                .append("4. Driving License")
                .append("\n")
                .append("5. Visit card")
                .append("\n")
                .append("6. ID photo")
                .toString());
        switch (Utils.intScanner()) {
            case 1, 3, 4, 5, 6 -> {
                Utils.notImplemented();
                menu();
            }
            case 2 -> moneyService.menu();
            default -> menu();
        }
    }
}
