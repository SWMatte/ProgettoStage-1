package it.progetto.progetto.controller;

import it.progetto.progetto.DTO.ProductDTO;
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
public class ProductController {

    @Autowired
    IService<Product> productIService;

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> getAll() {
        try{
            return productService.getAll();
        }catch(Exception e){
            return null;
        }
    }

    @PostMapping("/product")
    public ResponseEntity<String> add(@RequestBody Product product){
        try {
            productIService.add(product);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        try {
            productIService.remove(id);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @PutMapping("/product")
    public ResponseEntity<String> update(@RequestBody Product product){
        try {
            productIService.update(product);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @GetMapping("/productbetweendates")
    public List<Product> getProductBetweenDates(@RequestParam String data1, String data2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(data1);
        Date date2 = dateFormat.parse(data2);
        return productService.getProductBetweenDates(date,date2);
    }

    @GetMapping("/productbydate")
    public List<Product> getProductByDate(@RequestParam String data1) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(data1);
        return productService.getProductByDate(date);
    }

    @GetMapping("/productbyorder")
    public List<ProductDTO> getProductByOrders(@RequestParam String brand){
        return productService.getProductsByOrders(brand);
    }

}
