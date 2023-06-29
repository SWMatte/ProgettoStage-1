package it.progetto.progetto.controller;

import it.progetto.progetto.entities.Client;
import it.progetto.progetto.entities.Order;
import it.progetto.progetto.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    IService<Order> orderIService;

    @GetMapping("/order")
    public List<Order> getAll(){
        try{
            return orderIService.getAll();
        }catch(Exception e){
            return null;
        }
    }

    @PostMapping("/order")
    public ResponseEntity<String> add(@RequestBody Order order){
        try {
            orderIService.add(order);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        try {
            orderIService.remove(id);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @PutMapping("/order")
    public ResponseEntity<String> update(@RequestBody Order order){

        try {
            orderIService.update(order);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }
}
