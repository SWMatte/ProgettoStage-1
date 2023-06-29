package it.progetto.progetto.repositories;

import it.progetto.progetto.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBrandRepository extends JpaRepository<Brand,Integer> {

    public String findNameByIdBrand(int id);

    @Query(value = "SELECT brand_name FROM brand WHERE id_brand = :idBrand",nativeQuery = true)
    public String findNome(int idBrand);


}
