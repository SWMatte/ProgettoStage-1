package it.progetto.progetto.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_order",
            updatable = false,
            insertable = false
    )
    private int idOrder;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;

    @Transient
    @OneToMany(mappedBy = "orders",cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderDetails> orderDetails;


    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JoinTable(name = "Product_order",
            joinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id_product"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> products;


    @Temporal(TemporalType.DATE)
    private Date date;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", client=" + client +
                ", orderDetails=" + orderDetails +
                ", products=" + products +
                ", date=" + date +
                '}';
    }
}
