const { getPromptAsFloat, getPromptAsNumber } = require('./utils');

let balance = 0;
let latestActions = [];
let currency = "Ariary";

function print(message) {
    console.log(message);
}

function checkBalance() {
    print(`Your current balance is: ${balance} ${currency}`);
    latestActions.push(`You checked your balance. That was ${balance} ${currency}`);
}

function retrieveMoney() {
    print(`How much ${currency} do you want to get out of your wallet?`);
    const wantedMoney = getPromptAsFloat();
    if (balance > wantedMoney && wantedMoney >= 0) {
        balance = (balance - wantedMoney);
        const message = `You took ${wantedMoney} ${currency} out.`;
        print(message);
        latestActions.push(message);
    } else {
        print("You can't do that.");
        print(`Your current balance is: ${balance} ${currency}`);
    }
}

function storeMoney() {
    print(`How much ${currency} do you want to add?`);
    const moneyToAdd = getPromptAsFloat();
    if (moneyToAdd >= 0) {
        balance = (balance + moneyToAdd);
        const message = `You added ${moneyToAdd} ${currency} to your balance.`;
        print(message);
        latestActions.push(message);
    } else {
        print("You can't do that.");
    }
}

function convertCurrency() {
    print("Where are you now? Convert to your preferred currency.");
    print("1. To Euro.");
    print("2. To Dollar.");
    print("3. To Ariary.");
    const choice = getPromptAsNumber();
    switch (choice) {
        case 1:
            convertToChosenCurrency(currency, "Euro");
            break;
        case 2:
            convertToChosenCurrency(currency, "Dollar");
            break;
        case 3:
            convertToChosenCurrency(currency, "Ariary");
            break;
        default:
    
    }
}

function convertToChosenCurrency(currentCurrency, chosenCurrency) {
    if (currentCurrency === chosenCurrency) {
        print("It's already the current currency.");
    } else {
        currency = (chosenCurrency);
        const message = `You choose ${chosenCurrency} as currency.`;
        print(message);
        latestActions.push(message);
        if (balance > 0) {
            switch (currentCurrency) {
                case "Ariary":
                    chosenCurrency === "Dollar" ? balance = (balance * 0.00022) :
                        chosenCurrency === "Euro" ? balance = (balance * 0.00020) : null;
                    break;
                case "Dollar":
                    chosenCurrency === "Ariary" ? balance = (balance * 4582) :
                        chosenCurrency === "Euro" ? balance = (balance * 0.93) : null;
                    break;
                case "Euro":
                    chosenCurrency === "Ariary" ? balance = (balance * 4582) :
                        chosenCurrency === "Dollar" ? balance = (balance * 1.08) : null;
                    break;
            }
        }
    }
}

function history() {
    print("Your latest actions from recent to older:");
    latestActions.slice(-5).reverse().forEach(print);
}


module.exports = {
    checkBalance,
    retrieveMoney,
    storeMoney,
    convertCurrency,
    history,
    print
};