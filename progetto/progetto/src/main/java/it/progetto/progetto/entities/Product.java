package it.progetto.progetto.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_product",
            updatable = false,
            insertable = false
    )
    private int idProduct;

    @Column(
            name = "product_name",
            length = 255,
            nullable = false
    )
    private String name;

    @Column(
            name = "price",
            length = 255,
            nullable = false
    )
    private double price;

    @Column(
            name = "amount",
            length = 255,
            nullable = false
    )
    private int amount;

    @Column(
            name = "available",
            length = 255,
            nullable = false
    )
    boolean available;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "id_brand")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;

    @Temporal(TemporalType.DATE)
    private Date productionDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "products",cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders;




    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", available=" + available +
                ", brand=" + brand +
                ", productionDate=" + productionDate +
                ", orders=" + orders +
                '}';
    }
}
