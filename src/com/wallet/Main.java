package com.wallet;

import com.wallet.service.WalletService;

public class Main {
    static final WalletService walletService = new WalletService();
    public static void main(String[] args) {
        welcome();
        menu();
    }
    public static void welcome(){
        Utils.print("Hello! I'm your smart wallet\n" + "what do you want to do ?");
    }

    public static void menu() {
        Utils.print("Type a number between the given choice.");
        Utils.print(new StringBuilder()
                .append("1. Open your wallet")
                .append("\n")
                .append("2. Do nothing.")
                .append("\n")
                .toString());
        switch (Utils.intScanner()) {
            case 1 -> walletService.menu();
            case 2 -> Utils.quit();
            default -> menu();
        }
    }
}