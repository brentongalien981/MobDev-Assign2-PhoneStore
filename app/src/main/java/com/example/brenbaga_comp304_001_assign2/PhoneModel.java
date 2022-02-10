package com.example.brenbaga_comp304_001_assign2;

public class PhoneModel {

    public final String name;
    public final double price;
    public String storage;
    public String color;
    public final int imageResourceId;


    public PhoneModel(String name, double price, String storage, String color, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.storage = storage;
        this.color = color;
        this.imageResourceId = imageResourceId;
    }
}
