package com.company;

import com.company.models.*;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine {
    //region Properties
    private HashMap<String, ArrayList<ArrayList<Product>>> vendingMachine = new HashMap<>();
    //endregion

    //region Constructors

    //endregion

    //region Public Methods
    public HashMap<String, ArrayList<ArrayList<Product>>> initializeInventory() {
        HashMap<String, ArrayList<ArrayList<Product>>> table = new HashMap<>();
        ArrayList<ArrayList<Product>> chips = initializeChips();
        ArrayList<ArrayList<Product>> sodas = initializeSodas();
        ArrayList<ArrayList<Product>> miscellaneous = initializeMisc();

        table.put("A", chips);
        table.put("B", sodas);
        table.put("C", miscellaneous);

        return table;
    }


    private ArrayList<ArrayList<Product>> initializeChips() {
        ArrayList<Product> lays = new ArrayList<>();
        ArrayList<Product> doritos = new ArrayList<>();
        ArrayList<Product> pringles = new ArrayList<>();
        ArrayList<ArrayList<Product>> allProductsInRow = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lays.add(new LaysChips());
            doritos.add(new Doritos());
            pringles.add(new Pringles());
        }

        allProductsInRow.add(0, lays);
        allProductsInRow.add(1, doritos);
        allProductsInRow.add(2, pringles);
        return allProductsInRow;
    }

    private ArrayList<ArrayList<Product>> initializeSodas() {
        ArrayList<Product> cokes = new ArrayList<>();
        ArrayList<Product> fantas = new ArrayList<>();
        ArrayList<Product> waters = new ArrayList<>();
        ArrayList<ArrayList<Product>> allProductsInRow = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cokes.add(new CocaCola());
            fantas.add(new Fanta());
            waters.add(new BottledWater());
        }

        allProductsInRow.add(0, cokes);
        allProductsInRow.add(1, fantas);
        allProductsInRow.add(2, waters);
        return allProductsInRow;
    }

    private ArrayList<ArrayList<Product>> initializeMisc() {
        ArrayList<Product> masks = new ArrayList<>();
        ArrayList<Product> snickers = new ArrayList<>();
        ArrayList<Product> mnms = new ArrayList<>();
        ArrayList<ArrayList<Product>> allProductsInRow = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            masks.add(new Mask());
            snickers.add(new Snickers());
            mnms.add(new MnMs());
        }

        allProductsInRow.add(0, masks);
        allProductsInRow.add(1, snickers);
        allProductsInRow.add(2, mnms);
        return allProductsInRow;
    }

    public Product processCommand(Command command, VendingMachine vendingMachine) {
        ArrayList<ArrayList<Product>> tempRow = new ArrayList<>();
        ArrayList<Product> tempColumn;
        for (String i : vendingMachine.getVendingMachine().keySet()
        ) {
            if (command.getRow().equals(i)) {
                tempRow = vendingMachine.getVendingMachine().get(i);
            }
        }
        for (int i = 0; i < tempRow.size(); i++) {
            if (command.getColumn() == i) {
                tempColumn = tempRow.get(i);
                Product userProduct = tempColumn.get(i);
                userProduct.setType(tempColumn.get(i).toString());
                userProduct.setCount(command.getCount());
                return userProduct;
            }
        }
        return null;
    }


    //endregion

    //region Setters and Getters

    public HashMap<String, ArrayList<ArrayList<Product>>> getVendingMachine() {
        return vendingMachine;
    }


    public void setVendingMachine(HashMap<String, ArrayList<ArrayList<Product>>> vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    //endregion
}
