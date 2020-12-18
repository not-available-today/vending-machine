package com.company;

import com.company.models.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.setVendingMachine(machine.initializeInventory());

        Scanner scanner = new Scanner(System.in);

        Command userInput = new Command(scanner.nextLine());

        Product userProduct = machine.processCommand(userInput);

        machine.printReceipt(userProduct);
        machine.updateInventory(userInput);
    }

}
