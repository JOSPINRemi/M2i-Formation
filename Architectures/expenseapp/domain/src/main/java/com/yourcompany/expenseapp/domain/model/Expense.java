package com.yourcompany.expenseapp.domain.model;

public class Expense {
    private Long id;
    private String title;
    private double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private Expense(Builder builder) {
        setId(builder.id);
        setTitle(builder.title);
        setAmount(builder.amount);
    }

    public static class Builder{
        public Long id;
        public String title;
        public double amount;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }

        public Expense build(){
            return new Expense(this);
        }
    }
}
