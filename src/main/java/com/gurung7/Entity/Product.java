package com.gurung7.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="Products")

public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  pid;
    @Column(name = "ProductName", nullable = false)
    private String pname;
    @Column(name = "Quantity", nullable = false)
    private int qty;
    @Column(name = "Price", nullable = false)
    private double Price;

    public Product(String pname, int qty, double Price) {
        this.pname = pname;
        this.qty = qty;
        this.Price = Price;

    }

}
