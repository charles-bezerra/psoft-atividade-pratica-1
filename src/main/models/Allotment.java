package models;

import interfaces.Searchable;

public class Allotment implements Searchable {
    private static int count = -1;
    private int id;
    private Product product;
    private Integer amount;
    private String expiretionDate;

    public Allotment(Product product, Integer amount, String expiretionDate) {
        this.product = product;
        this.amount = amount;
        this.expiretionDate = expiretionDate;
        generateId();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    private void generateId() {
        this.id = ++Allotment.count;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getExpirationDate() {
        return expiretionDate;
    }

    public void setExpirationDate(String expiretionDate) {
        this.expiretionDate = expiretionDate;
    }

    @Override
    public String toString() {
        return "Allotment{" +
                "id=" + id +
                ", product=" + product +
                ", amount=" + amount +
                ", expiretionDate='" + expiretionDate + '\'' +
                '}';
    }
}
