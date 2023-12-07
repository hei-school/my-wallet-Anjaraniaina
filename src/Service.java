import java.util.List;

public class Service {
    private int balance;

    public Service() {
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        print("Your current balance is: "+ balance + " Ar.");
    }

    public void retrieveMoney() {
        print("How much Ar do you want to get out of your wallet ?");
        int wantedMoney = Main.scanner();
        if(balance > wantedMoney && wantedMoney >= 0) {
            setBalance(balance - wantedMoney);
            print("You taked " + balance + " Ar out.");
        } else if (balance < wantedMoney) {
            print("You can't do that!");
            checkBalance();
        }
    }

    public void storeMoney() {
        print("How much Ar do you want to add ?");
    }

    public int epargneMoney() {
    }

    public List<Integer> history() {
    }

    public static void print(String sentence) {
        System.out.println(sentence);
    }
}
