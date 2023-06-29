package it.progetto.progetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoApplication.class, args);
	}

}
/*
*
* spring.datasource.url=jdbc:mysql://localhost:3306/progetto
spring.datasource.username=root
spring.datasource.password=0_mysql_1
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

connessione



update:

 @Modifying
    @Transactional
    @Query("UPDATE Client u SET u.address=?1, u.age=?2, u.creditCard=?3, u.firstName=?4, u.lastName=?5, u.password=?6, u.username=?7 WHERE u.idClient = ?8")
    public void updateClient(String address,int age,String creditCard,String firstName,String lastName,String password,String username, i

dto dependence

	<dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>2.4.4</version>
		</dependency>
	</dependencies>




ONE TO MANY

 @JsonIgnore
   @OneToMany(mappedBy = "brand",cascade = CascadeType.REMOVE)
   @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> product;

MANY TO ONE

   @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "id_brand")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;


MANY TO MANY

PARTE CHE RICEVE
  @JsonIgnore
    @ManyToMany(mappedBy = "products",cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders;

parte padre ->

   @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JoinTable(name = "Product_order",
            joinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id_product"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> products;



one to one questo sta nella classe che non è address

 @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

chi riceve

@OneToOne(mappedBy = "address")
    private User user;

*
* */