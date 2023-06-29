package it.progetto.progetto.repositories;

import it.progetto.progetto.DTO.ProductDTO;
import it.progetto.progetto.entities.Brand;
import it.progetto.progetto.entities.Client;
import it.progetto.progetto.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT price FROM product INNER JOIN product_order USING(id_product) WHERE id_order = :idOrder", nativeQuery = true)
    public List<Double> findPriceByIdOrder(int idOrder);

    @Modifying
    @Transactional
    @Query("UPDATE Product u SET u.name = ?1, u.price = ?2, u.amount = ?3, u.available = ?4, u.brand = ?5, u.productionDate = ?6 WHERE u.idProduct = ?7")
    void updateBrand(String productName, double price, int amount, boolean available, Brand brand, Date productionDate, int idProduct);

    @Query(value = "SELECT * FROM product WHERE production_date BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Product> selectBetweenDates(Date data1, Date data2);

    @Query(value = "SELECT * FROM product WHERE production_date = :data1",nativeQuery = true)
    List<Product> selectProductByDate(Date data1);

    @Query("SELECT new it.progetto.progetto.DTO.ProductDTO( p.id, p.name, COUNT(o.id) )" +
            "FROM Product p " +
            "INNER JOIN p.orders o " +
            "INNER JOIN p.brand b " +
            "WHERE b.name = :brand " +
            "GROUP BY p.id, p.name " +
            "ORDER BY COUNT(o.id) DESC " +
            "LIMIT 1"
    )
    List<ProductDTO> selectProductsByOrders(String brand);

    /*
    @Query("""
            SELECT p.id, p.name, COUNT(o.id) AS nrAcquisti
            FROM Product p
            INNER JOIN p.orders o
            INNER JOIN p.brand b
            WHERE b.name = :brand
            GROUP BY p.id, p.name
            ORDER BY COUNT(o.id) DESC
            LIMIT 1"""
    )

*/

}
