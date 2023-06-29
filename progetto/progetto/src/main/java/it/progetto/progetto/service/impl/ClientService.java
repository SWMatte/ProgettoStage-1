package it.progetto.progetto.service.impl;

import it.progetto.progetto.DTO.ClientDTO;
import it.progetto.progetto.DTO.ModelMapperConfig;
import it.progetto.progetto.entities.Client;
import it.progetto.progetto.repositories.IClientRepository;
import it.progetto.progetto.service.IService;
import it.progetto.progetto.service.IServiceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IService<Client>, IServiceDTO<ClientDTO> {

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void add(Client client) {
        //client.checkAddress();
        clientRepository.save(client);
    }

    @Override
    public void remove(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        clientRepository.updateClient(client.getAddress(), client.getAge(), client.getCreditCard(), client.getFirstName(), client.getLastName(), client.getPassword(), client.getUsername(), client.getIdClient());
        return client;
    }

    @Override
    public List<ClientDTO> getAllDTO(){
        List<Client> listaClients = clientRepository.findAll();

        List<ClientDTO> listaClientDTO = listaClients.stream()
                .map(e -> modelMapper.map(e, ClientDTO.class))
                .peek(i -> i.setCreditCard(i.getCreditCard().substring(0, 3) + "****"))
                .collect(Collectors.toList());


        return listaClientDTO;
    }


}
