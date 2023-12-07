from money_management import check_balance, retrieve_money, store_money, convert_currency, history
import sys

def quit_program():
    print("See you later!")
    sys.exit()

menu_actions = [check_balance, retrieve_money, store_money, convert_currency, history, quit_program]

def menu():
    print("""
    1. Check your current balance.
    2. Take out money.
    3. Store money.
    4. Convert to another currency.
    5. Check your 5 latest actions.
    6. Quit.
    """)
    choice = int(input())
    if 1 <= choice <= 6:
        menu_actions[choice - 1]()
        menu()
    else:
        menu()

menu()