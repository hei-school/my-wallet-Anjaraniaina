balance = 0
latest_actions = []
currency = "Ariary"
currencies = ["Euro", "Dollar", "Ariary"]

def check_balance():
    print(f"Your current balance is: {balance} {currency}")
    latest_actions.append(f"You checked your balance. That was {balance} {currency}")

def retrieve_money():
    global balance
    wanted_money = float(input(f"How much {currency} do you want to get out of your wallet? "))
    if balance > wanted_money >= 0:
        balance =- wanted_money
        message = f"You took {wanted_money} {currency} out."
        print(message)
        latest_actions.append(message)
    else:
        print("You can't do that.")
        print(balance)

def store_money():
    global balance
    money_to_add = float(input(f"How much {currency} do you want to add? "))
    if money_to_add >= 0:
        balance += money_to_add
        message = f"You added {money_to_add} {currency} to your balance."
        print(message)
        latest_actions.append(message)
    else:
        print("You can't do that.")

def convert_currency():
    print("Where are you now? Convert to your preferred currency.")
    print("1. To Euro.")
    print("2. To Dollar.")
    print("3. To Ariary.")
    choice = int(input())
    if 1 <= choice <= 3:
        convert_to_chosen_currency(currency, currencies[choice - 1])
    else:
        print("Choose between them")
        convert_currency()

def convert_to_chosen_currency(current_currency, chosen_currency):
    global currency, balance
    if current_currency == chosen_currency:
        print("It's already the current currency.")
    else:
        currency = chosen_currency
        message = f"You choose {chosen_currency} as currency."
        print(message)
        latest_actions.append(message)
        if balance > 0:
            conversion_rate = exchange_rate(current_currency, chosen_currency)
            balance = (balance * conversion_rate)

def exchange_rate(current_currency, chosen_currency):
    if current_currency == "Ariary":
        return exchange_rate_ariary(chosen_currency)
    elif current_currency == "Dollar":
        return exchange_rate_dollar(chosen_currency)
    elif current_currency == "Euro":
        return exchange_rate_euro(chosen_currency)

def exchange_rate_ariary(chosen_currency):
    if chosen_currency == "Dollar":
        return 0.00022
    elif chosen_currency == "Euro":
        return 0.00020
    else:
        return 1.0

def exchange_rate_dollar(chosen_currency):
    if chosen_currency == "Ariary":
        return 4582
    elif chosen_currency == "Euro":
        return 0.93
    else:
        return 1.0

def exchange_rate_euro(chosen_currency):
    if chosen_currency == "Ariary":
        return 4582
    elif chosen_currency == "Dollar":
        return 1.08
    else:
        return 1.0

def history():
    print("Your latest actions from recent to older")
    reversed_actions = latest_actions[-5:][::-1]
    for action in reversed_actions:
        print(action)
