package com.example.pokedex;
//Pokemon class according to firebase data structure with getter, setter and constructors
public class Pokemon {
    private String details;
    private String img;
    private String name;
    private int price;

    public Pokemon(String details, String img, String name, int price, String type, String weakness) {
        this.details = details;
        this.img = img;
        this.name = name;
        this.price = price;
        this.type = type;
        this.weakness = weakness;
    }

    public Pokemon(){}

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    private String type;
    private String weakness;



}
