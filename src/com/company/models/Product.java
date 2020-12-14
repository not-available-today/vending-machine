package com.company.models;

public abstract class Product {

    //region Properties
    private String type;
    private int count;
    //endregion

    //region Constructors

    //endregion

    //region Public Methods
    public void printReceipt(){
        System.out.println("Enjoy your "+ this.count + " " +this.type );
    }

    //endregion

    //region Setters and Getters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    //endregion
}
