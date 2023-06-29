package it.progetto.progetto.service.impl;

import it.progetto.progetto.entities.Brand;
import it.progetto.progetto.repositories.IBrandRepository;
import it.progetto.progetto.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IService<Brand> {

    @Autowired
    IBrandRepository brandRepository;


    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public void add(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void remove(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Brand update(Brand brand) {


        return brand;
    }
}
