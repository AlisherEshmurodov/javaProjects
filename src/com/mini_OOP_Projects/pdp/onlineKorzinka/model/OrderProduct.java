package com.mini_OOP_Projects.pdp.onlineKorzinka.model;

public class OrderProduct {
    private Order order;
    private Product product;
    private double quantity;
    private double sum;

    public OrderProduct(Order order, Product product, double quantity, double sum) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.sum = sum;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
