package it.progetto.progetto.service.impl;

import it.progetto.progetto.entities.Brand;
import it.progetto.progetto.entities.Order;
import it.progetto.progetto.entities.OrderDetails;
import it.progetto.progetto.repositories.IBrandRepository;
import it.progetto.progetto.repositories.IOrderDetailsRepository;
import it.progetto.progetto.repositories.IOrderRepository;
import it.progetto.progetto.repositories.IProductRepository;
import it.progetto.progetto.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService implements IService<OrderDetails> {

    @Autowired
    IOrderDetailsRepository orderDetailsRepository;
    @Autowired
    IProductRepository productRepository;

    @Autowired
    IOrderRepository orderRepository;

    @Override
    public List<OrderDetails> getAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public void add(OrderDetails orderDetails) {
        Order existingOrder = orderRepository.findById(orderDetails.getOrders().getIdOrder());

        if (existingOrder != null) {
            orderDetailsRepository.saveOrderDetails(orderDetails.getDescrizioneProdotto(),orderDetails.getOrders().getIdOrder());
        }
    }

    @Override
    public void remove(int id) {
    orderDetailsRepository.deleteById(id);
    }

    @Override
    public OrderDetails update(OrderDetails orderDetails) {
        return null;
    }
}
