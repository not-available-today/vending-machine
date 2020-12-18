package com.company;

import com.company.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class VendingMachine {
    //region Properties
    private HashMap<String, ArrayList<LinkedList<Product>>> vendingMachine;
    //endregion

    //region Constructors

    //endregion

    //region Public Methods
    public  HashMap<String, ArrayList<LinkedList<Product>>> initializeInventory() {
        HashMap<String, ArrayList<LinkedList<Product>>> table = new HashMap<>();
        ArrayList<LinkedList<Product>> chips = initializeChips();
        ArrayList<LinkedList<Product>> sodas = initializeSodas();
        ArrayList<LinkedList<Product>> miscellaneous = initializeMisc();

        table.put("A", chips);
        table.put("B", sodas);
        table.put("C", miscellaneous);

        return table;
    }


    private ArrayList<LinkedList<Product>> initializeChips() {
        LinkedList<Product> lays = new LinkedList<>();
        LinkedList<Product> doritos = new LinkedList<>();
        LinkedList<Product> pringles = new LinkedList<>();
        ArrayList<LinkedList<Product>> allProductsInRow = new ArrayList<>();
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

    private ArrayList<LinkedList<Product>> initializeSodas() {
        LinkedList<Product> cokes = new LinkedList<>();
        LinkedList<Product> fantas = new LinkedList<>();
        LinkedList<Product> waters = new LinkedList<>();
        ArrayList<LinkedList<Product>> allProductsInRow = new ArrayList<>();
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

    private ArrayList<LinkedList<Product>> initializeMisc() {
        LinkedList<Product> masks = new LinkedList<>();
        LinkedList<Product> snickers = new LinkedList<>();
        LinkedList<Product> mnms = new LinkedList<>();
        ArrayList<LinkedList<Product>> allProductsInRow = new ArrayList<>();
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

    public Product processCommand(Command command) {
        ArrayList<LinkedList<Product>> row = assignRow(command);
        LinkedList<Product> column = assignColumn(command, row);
        return returnProduct(command,column);

    }

    private ArrayList<LinkedList<Product>> assignRow(Command command) {
        ArrayList<LinkedList<Product>> tempRow = new ArrayList<>();
        for (String i : vendingMachine.keySet()
        ) {
            if (command.getRow().equals(i)) {
                tempRow = vendingMachine.get(i);
            }
        }
        return tempRow;
    }

    private LinkedList<Product> assignColumn(Command command, ArrayList<LinkedList<Product>> tempRow) {
        LinkedList<Product> tempColumn = new LinkedList<>();
        for (int i = 0; i < tempRow.size(); i++) {
            if (command.getColumn() == i) {
                tempColumn = tempRow.get(i);
            }
        }
        return tempColumn;
    }

    private Product returnProduct(Command command, LinkedList<Product> tempColumn){
        Product userProduct = new Product();
        userProduct.setCount(command.getCount());
        for (int i = 0; i < tempColumn.size(); i++) {
            if (command.getColumn() == i) {
                userProduct = tempColumn.get(i);
                userProduct.setType(tempColumn.get(i).toString());
            }
        }

        userProduct.setCount(command.getCount());

        return userProduct;
    }

    public void updateInventory(Command command){
        ArrayList<LinkedList<Product>> row = assignRow(command);
        LinkedList<Product> column = assignColumn(command, row);
        Product userProduct = returnProduct(command,column);
        for (int i = 0; i < command.getCount(); i++) {
            column.poll();
        }
        System.out.println("Remaining stock of " + userProduct.getType() +":" + column.size());
    }

    public void printReceipt(Product product){
        System.out.println("Enjoy your "+ product.getCount() + " " +product.getType() );
    }



    //endregion

    //region Setters and Getters


    public HashMap<String, ArrayList<LinkedList<Product>>> getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(HashMap<String, ArrayList<LinkedList<Product>>> vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
//endregion
}
