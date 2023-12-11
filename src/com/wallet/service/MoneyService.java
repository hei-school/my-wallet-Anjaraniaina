package com.wallet.service;

import java.util.Collections;
import java.util.List;

import com.wallet.Utils;
import com.wallet.abstraction.Compartment;

public class MoneyService implements Compartment {
    private double balance;
    private List<String> latestActions;

    private String currency;
    static final String cannotDo = "You can't do that.";

    final WalletService walletService = new WalletService();


    public MoneyService(double balance, List<String> latestActions, String currency) {
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
        Utils.print("Your current balance is: "+ this.balance + " " + currency);
    }

    public void setLatestActions(String actionToAdd) {
        this.latestActions.add(actionToAdd);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        Utils.print("Your current balance is: "+ this.balance + " " + currency);
        setLatestActions("You checked your balance. That was " + this.balance + " " + currency);
        menu();
    }

    public void retrieveMoney() {
        Utils.print("How much " + currency + " do you want to get out of your wallet ?");
        double wantedMoney = Utils.doubleScanner();
        if(this.balance > wantedMoney && wantedMoney >= 0) {
            setBalance(this.balance - wantedMoney);
            String message = "You took " + wantedMoney + " " + currency + " out.";
            Utils.print(message);
            setLatestActions(message);
        } else {
            Utils.print(cannotDo);
            getBalance();
        }
        menu();
    }

    public void storeMoney() {
        Utils.print("How much " + currency + " do you want to add ?");
        double moneyToAdd = Utils.doubleScanner();
        if(moneyToAdd >= 0) {
            setBalance(this.balance + moneyToAdd);
            String message = "You added " + moneyToAdd + " " + currency + " to your balance.";
            Utils.print(message);
            setLatestActions(message);
        } else {
            Utils.print(cannotDo);
        }
        menu();
    }


    public void convertCurrency(){
        Utils.print("Where are you now ? Convert to your preferred currency.");
        Utils.print(new StringBuilder()
                .append("1. To Euro.")
                .append("\n")
                .append("2. To Dollar.")
                .append("\n")
                .append("3. To Ariary.")
                .append("\n")
                .toString());
        switch (Utils.intScanner()) {
            case 1 -> convertToChosenCurrency(currency, "Euro");
            case 2 -> convertToChosenCurrency(currency, "Dollar");
            case 3 -> convertToChosenCurrency(currency, "Ariary");
            default -> menu();
        }
        menu();
    }

    public void convertToChosenCurrency(String currentCurrency, String chosenCurrency) {
        if(currentCurrency.equals(chosenCurrency)){
            Utils.print("It's already the current currency.");
        } else {
            setCurrency(chosenCurrency);
            String message = "You choose " + chosenCurrency + " as currency.";
            Utils.print(message);
            latestActions.add(message);
            if(balance > 0) {
                switch (currentCurrency) {
                    case "Ariary" -> {
                        switch (chosenCurrency) {
                            case "Dollar" -> setBalance(balance * 0.00022);
                            case "Euro" -> setBalance(balance * 0.00020);
                        }
                    }
                    case "Dollar" -> {
                        switch (chosenCurrency) {
                            case "Ariary" -> setBalance(balance * 4582);
                            case "Euro" -> setBalance(balance * 0.93);
                        }
                    }
                    case "Euro" -> {
                        switch (chosenCurrency) {
                            case "Ariary" -> setBalance(balance * 4582);
                            case "Dollar" -> setBalance(balance * 1.08);
                        }
                    }
                }
            }
        }
    }

    public void history() {
        Utils.print("Your latest actions from recent to older:");
        Collections.reverse(latestActions);
        if(latestActions.size() > 5){
            for (int i = 0; i < 5; i++) {
                Utils.print(latestActions.get(i));
            }
        } else {
            latestActions.forEach(Utils::print);
        }
        menu();
    }

    @Override
    public void menu() {
        Utils.print(new StringBuilder()
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
                .append("6. See other objects")
                .toString());
        switch (Utils.intScanner()) {
            case 1 -> checkBalance();
            case 2 -> retrieveMoney();
            case 3 -> storeMoney();
            case 4 -> convertCurrency();
            case 5 -> history();
            case 6 -> precedentMenu();
            default -> menu();
        }
    }

    @Override
    public void precedentMenu() {
        walletService.menu();
    }
}
