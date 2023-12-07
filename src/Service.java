import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Service {
    private double balance;
    private List<String> latestActions;
    static final String cannotDo = "You can't do that.";

    private String currency;

    public Service(double balance, List<String> latestActions, String currency) {
        this.balance = balance;
        this.latestActions = latestActions;
        this.currency = currency;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void getBalance() {
        print("Your current balance is: "+ this.balance + " " + currency);
    }

    public void setLatestActions(String actionToAdd) {
        this.latestActions.add(actionToAdd);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        print("Your current balance is: "+ this.balance + " " + currency);
        setLatestActions("You checked your balance. That was " + this.balance + " " + currency);
        Main.menu();
    }

    public void retrieveMoney() {
        print("How much " + currency + " do you want to get out of your wallet ?");
        double wantedMoney = Main.doubleScanner();
        if(this.balance > wantedMoney && wantedMoney >= 0) {
            setBalance(this.balance - wantedMoney);
            String message = "You took " + wantedMoney + " " + currency + " out.";
            print(message);
            setLatestActions(message);
        } else {
            print(cannotDo);
            getBalance();
        }
        Main.menu();
    }

    public void storeMoney() {
        print("How much " + currency + " do you want to add ?");
        double moneyToAdd = Main.doubleScanner();
        if(moneyToAdd >= 0) {
            setBalance(this.balance + moneyToAdd);
            String message = "You added " + moneyToAdd + " " + currency + " to your balance.";
            print(message);
            setLatestActions(message);
        } else {
            print(cannotDo);
        }
        Main.menu();
    }


    public void convertCurrency(){
        print("Where are you now ? Convert to your preferred currency.");
        Service.print(new StringBuilder()
                .append("1. To Euro.")
                .append("\n")
                .append("2. To Dollar.")
                .append("\n")
                .append("3. To Ariary.")
                .append("\n")
                .toString());
        switch (Main.intScanner()) {
            case 1 -> convertToChoosenCurrency(currency, "Euro");
            case 2 -> convertToChoosenCurrency(currency, "Dollar");
            case 3 -> convertToChoosenCurrency(currency, "Ariary");
            default -> Main.menu();
        }
        Main.menu();
    }

    public void convertToChoosenCurrency(String currentCurrency, String choosenCurrency) {
        if(currentCurrency.equals(choosenCurrency)){
            print("It's already the current currency.");
        } else {
            setCurrency(choosenCurrency);
            String message = "You choose " + choosenCurrency + " as currency.";
            print(message);
            latestActions.add(message);
            if(balance > 0) {
                switch (currentCurrency) {
                    case "Ariary" -> {
                        switch (choosenCurrency) {
                            case "Dollar" -> setBalance(balance * 0.00022);
                            case "Euro" -> setBalance(balance * 0.00020);
                        }
                    }
                    case "Dollar" -> {
                        switch (choosenCurrency) {
                            case "Ariary" -> setBalance(balance * 4582);
                            case "Euro" -> setBalance(balance * 0.93);
                        }
                    }
                    case "Euro" -> {
                        switch (choosenCurrency) {
                            case "Ariary" -> setBalance(balance * 4582);
                            case "Dollar" -> setBalance(balance * 1.08);
                        }
                    }
                }
            }
        }
    }

    public void history() {
        print("Your latest actions from recent to older");
        Collections.reverse(latestActions);
        if(latestActions.size() > 5){
            for (int i = 0; i < 5; i++) {
                print(latestActions.get(i));
            }
        } else {
            latestActions.forEach(Service::print);
        }
        Main.menu();
    }

    public static void print(String sentence) {
        System.out.println(sentence);
    }
}
