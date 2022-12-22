package com.mini_OOP_Projects.pdp.onlineKorzinka.model;

public class ShopProduct {
    private Shop shop;
    private Product product;
    private double quantity;

    public ShopProduct(Shop shop, Product product, double quantity) {
        this.shop = shop;
        this.product = product;
        this.quantity = quantity;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
