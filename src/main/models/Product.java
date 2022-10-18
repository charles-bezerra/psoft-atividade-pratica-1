package models;

import interfaces.Searchable;

public class Product implements Searchable {
    public static int count;
    private Integer id;
    private String name;
    private String manufacturing;
    private float price;

    public Product(String name, String manufacturing, float price) {
        this.name = name;
        this.manufacturing = manufacturing;
        this.price = price;
        generateId();
    }

    public Integer getId() {
        return id;
    }

    private void generateId() {
        this.id = ++Product.count;
    }

    public String getName() {
        return this.name;
    }

    public String getManufacturing() {
        return this.manufacturing;
    }

    public float getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object outher) {
        if (outher == null) {
            return false;
        }

        if (outher.getClass() != Product.class) {
            return false;
        }

        return this.id == ((Product) outher).getId();
    }
}
