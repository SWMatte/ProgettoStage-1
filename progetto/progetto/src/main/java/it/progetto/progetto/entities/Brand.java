package it.progetto.progetto.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id_brand",
            updatable = false,
            insertable = false
    )
    private int idBrand;

    @Column(
            name = "brand_name",
            length = 255,
            nullable = false
    )
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "brand",cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> product;

/*
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name= "id_catalog_brand")
    private Catalog catalogBrand;*/









    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

   /* public Catalog getCatalogBrand() {
        return catalogBrand;
    }

    public void setCatalogBrand(Catalog catalogBrand) {
        this.catalogBrand = catalogBrand;
    }*/
}
