package it.progetto.progetto.controller;

import it.progetto.progetto.entities.Brand;
import it.progetto.progetto.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    IService<Brand> brandIService;

    @GetMapping("/brand")
    public List<Brand> getAll() {
        try{
            return brandIService.getAll();
        }catch(Exception e){
            return null;
        }
    }

    @PostMapping("/brand")
    public ResponseEntity<String> add(@RequestBody Brand brand) {
       try {
           brandIService.add(brand);
           return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
       }catch (Exception e){

           return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

       }

    }



    @DeleteMapping("/brand/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        try {
            brandIService.remove(id);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @PutMapping("/brand")
    public ResponseEntity<String> update(@RequestBody Brand brand) {
        try {
            brandIService.update(brand);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }


}
