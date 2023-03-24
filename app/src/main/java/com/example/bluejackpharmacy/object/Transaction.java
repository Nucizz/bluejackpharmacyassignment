package com.example.bluejackpharmacy.object;

public class Transaction extends User {

    private int id;
    private Medicine item;
    private int quantity;
    private String transcationDate;

    public Transaction(int id, User user, Medicine item, int quantity, String transcationDate) {
        super(user.getId(), user.getName(), user.getEmail(), user.getHashed(), user.getPhone());
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.transcationDate = transcationDate;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicine getItem() {
        return item;
    }

    public void setItem(Medicine item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTranscationDate() {
        return transcationDate;
    }

    public void setTranscationDate(String transcationDate) {
        this.transcationDate = transcationDate;
    }
}
