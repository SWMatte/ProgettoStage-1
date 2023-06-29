package it.progetto.progetto.service.impl;

import it.progetto.progetto.entities.Client;
import it.progetto.progetto.entities.Order;
import it.progetto.progetto.entities.Product;
import it.progetto.progetto.repositories.IClientRepository;
import it.progetto.progetto.repositories.IOrderRepository;
import it.progetto.progetto.repositories.IProductRepository;
import it.progetto.progetto.service.IService;
import jakarta.persistence.PrePersist;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements IService<Order> {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IClientRepository clientRepository;


    @Override
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @Override
    public void add(Order order) {
        Client existingClient = clientRepository.findById(order.getClient().getIdClient());
        if (existingClient != null) {
            Order order1 = new Order();
            order.setClient(existingClient);
            orderRepository.save(order);

        }

    }

    @Override
    public void remove(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order update(Order order) {
        return null;
    }

}
