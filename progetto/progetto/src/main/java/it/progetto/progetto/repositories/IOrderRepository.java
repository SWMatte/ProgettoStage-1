package it.progetto.progetto.repositories;

import it.progetto.progetto.entities.Brand;
import it.progetto.progetto.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<Order,Integer> {

    Order findById(int id);

}
