package com.codsoft.atm;

public interface ATMInterface {
    void withdraw(double amount);
    void deposit(double amount);
    double checkBalance();
}
