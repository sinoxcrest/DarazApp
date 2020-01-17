package com.example.daraz.model;

public class Products {

    private String Description;
    private String Image;
    private float Price;

    public Products( String image,String description, float price) {
        Description = description;
        Image = image;
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

}
