package it.progetto.progetto.service.impl;

import it.progetto.progetto.DTO.ProductDTO;
import it.progetto.progetto.entities.Product;
import it.progetto.progetto.repositories.IBrandRepository;
import it.progetto.progetto.repositories.IProductRepository;
import it.progetto.progetto.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IService<Product> {

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IBrandRepository iBrandRepository;


    @Override
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {

            productRepository.save(product);

    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        productRepository.updateBrand(product.getName(), product.getPrice(), product.getAmount(), product.isAvailable(), product.getBrand(),product.getProductionDate(), product.getIdProduct());
        return product;
    }

    public List<Product> getProductBetweenDates(Date data1, Date data2){
        return productRepository.selectBetweenDates(data1,data2);
    }

    public List<Product> getProductByDate(Date data1){
        return productRepository.selectProductByDate(data1);
    }

    public  List<ProductDTO> getProductsByOrders(String brand){

        return  productRepository.selectProductsByOrders(brand);

    }
}
