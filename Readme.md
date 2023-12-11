# Wallet Java

## Description
This is the implementation of the wallet project in Java.
### Features:
The service for unchecked item are not implemented yet.
1. [ ] CIN
2. [x] Money
3. [ ] Bank cards
4. [ ] Driving License
5. [ ] Visit card
6. [ ] ID Photo
7. [x] Wallet

## Installation
If you already have a java environment set-up, skip to the **How To use**.
### Requirements
* [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21): follow the link to download and install the JDK for your operating system.


## How to use ?
If you don't have an IDE but have a java setup, from the root directory just run these commands:
```
javac -d . ./src/com/wallet/*.java ./src/com/wallet/abstraction/*.java ./src/com/wallet/exception/*.java ./src/com/wallet/service/*.java
java com.wallet.Main
```