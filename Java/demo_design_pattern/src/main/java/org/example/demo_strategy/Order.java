package org.example.demo_strategy;

public class Order {
    private double totalAmount;

    public Order(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void pay(PaymentStrategy paymentStrategy){
        if (paymentStrategy.pay(totalAmount)){
            System.out.println("Order confirmed");
        }
        else System.out.println("Order not confirmed");
    }
}
