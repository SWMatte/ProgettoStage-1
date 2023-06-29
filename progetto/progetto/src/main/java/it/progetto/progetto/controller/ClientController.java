package it.progetto.progetto.controller;

import it.progetto.progetto.DTO.ClientDTO;
import it.progetto.progetto.entities.Client;
import it.progetto.progetto.service.IService;
import it.progetto.progetto.service.IServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    IService<Client> clientIService;

    @Autowired
    IServiceDTO<ClientDTO> clientDTOservice;

    @GetMapping("/client")
    public List<Client> getAll() {
        try {
            return clientIService.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/client")
    public ResponseEntity<String> add(@RequestBody Client client) {
        try {
            clientIService.add(client);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }

    }

    @DeleteMapping("/client/{id}")
    public  ResponseEntity<String> deleteById(@PathVariable int id) {
        try {
            clientIService.remove(id);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @PutMapping("/client")
    public  ResponseEntity<String> update(@RequestBody Client client) {
        try {
            clientIService.update(client);
            return ResponseEntity.ok(String.valueOf(HttpStatus.OK.value()));
        }catch (Exception e){

            return ResponseEntity.ok(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        }
    }

    @GetMapping("/client-dto")
    public List<ClientDTO> getClientDTO() {
        try {
            return clientDTOservice.getAllDTO();
        } catch (ParseException e) {
            e.getMessage();
            return null;
        }
    }


}
