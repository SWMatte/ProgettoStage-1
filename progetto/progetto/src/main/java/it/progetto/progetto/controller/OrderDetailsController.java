package it.progetto.progetto.controller;

import it.progetto.progetto.entities.OrderDetails;
import it.progetto.progetto.entities.Product;
import it.progetto.progetto.service.IService;
import it.progetto.progetto.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class OrderDetailsController {

    @Autowired
    IService<OrderDetails> orderDetailsIService;

    @GetMapping("/orderdetails")
    public List<OrderDetails> getAll(){
        try{
            return orderDetailsIService.getAll();
        }catch(Exception e){
            return null;
        }
    }

    @PostMapping("/orderdetails")
    public ResponseEntity<String> add(@RequestBody OrderDetails orderDetails){
        try {
            orderDetailsIService.add(orderDetails);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @DeleteMapping("/orderdetails/{id}")
    public ResponseEntity<String>  deleteById(@PathVariable int id){

        try {
            orderDetailsIService.remove(id);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @PutMapping("/orderdetails")
    public ResponseEntity<String>  update(@RequestBody OrderDetails orderDetails){
        try {
            orderDetailsIService.update(orderDetails);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }


}
