package org.example.TP3P1.EXO1.EXO2;

import java.util.Objects; // N'oublie pas cet import !

public class Order {

    private String id;
    private String product;
    private int quantity;
    private double totalPrice;

    public Order(String id, String product, int quantity, double totalPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getId()          { return id; }
    public String getProduct()     { return product; }
    public int getQuantity()       { return quantity; }
    public double getTotalPrice()  { return totalPrice; }

    @Override
    public String toString() {
        return "Order{id='" + id + "', product='" + product +
                "', qty=" + quantity + ", total=" + totalPrice + "}";
    }

    // --------------------------------------------------------
    // AJOUTS INDISPENSABLES POUR QUE LES TESTS MOCKITO PASSENT
    // --------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        // Compare les valeurs exactes des propriétés
        return quantity == order.quantity &&
                Double.compare(order.totalPrice, totalPrice) == 0 &&
                Objects.equals(id, order.id) &&
                Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity, totalPrice);
    }
}