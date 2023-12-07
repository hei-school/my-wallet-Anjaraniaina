const {
    checkBalance,
    retrieveMoney,
    storeMoney,
    convertCurrency,
    history,
    print,
} = require('./money_service');

const { getPromptAsNumber } = require('./utils')

function quit() {
    print("See you later!");
    process.exit();
}

function menu() {
    print(`
    1. Check your current balance.
    2. Take out money.
    3. Store money.
    4. Convert to another currency.
    5. Check your 5 latest transactions.
    6. Quit.
  `);
    const choice = getPromptAsNumber();
    print(choice)
    switch (choice) {
        case 1:
            checkBalance();
            menu();
            break;
        case 2:
            retrieveMoney();
            menu();
            break;
        case 3:
            storeMoney();
            menu();
            break;
        case 4:
            convertCurrency();
            menu();
            break;
        case 5:
            history();
            menu();
            break;
        case 6:
            quit();
            break;
        default:
            menu();
    }
}

menu();
