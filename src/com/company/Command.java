package com.company;

public class Command {
    //region Properties
    private String row;
    private int column;
    private int count;
    //endregion

    //region Constructors

    public Command(String input) {
        String[] inputArray = input.split(":");
        row = inputArray[0];
        column = Integer.parseInt(inputArray[1]);
        count = Integer.parseInt(inputArray[2]);
    }

    //endregion

    //region Public Methods

    //endregion

    //region Setters and Getters

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //endregion
}
