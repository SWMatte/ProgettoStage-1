package it.progetto.progetto.repositories;

import it.progetto.progetto.entities.Brand;
import it.progetto.progetto.entities.OrderDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO order_details  (descr_prod, id_order) " +
            "VALUES (:descrizioneProdotto, :orderId)",nativeQuery = true)
    void saveOrderDetails(String descrizioneProdotto, int orderId);

}
