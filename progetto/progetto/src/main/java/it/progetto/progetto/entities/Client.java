package it.progetto.progetto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "id_client",
        updatable = false,
        insertable = false
    )
    private int idClient;

    @Column(
            name = "first_name",
            length = 255
    )
    private String firstName;

    @Column(
            name = "last_name",
            length = 255
    )
    private String lastName;

    @Column(
            name = "age"
    )
    private int age;

    @Column(
            name = "credit_card",
            length = 255
    )
    private String creditCard;

    @Column(
            name = "username",
            length = 255,
            unique = true
    )
    private String username;

    @Column(
            name = "password",
            length = 255
    )
    private String password;

    @Column(
            name = "address",
            length = 255
    )
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "client",cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders;


    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", creditCard='" + creditCard + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
