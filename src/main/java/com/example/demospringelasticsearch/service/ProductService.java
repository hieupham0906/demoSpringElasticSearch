package com.example.demospringelasticsearch.service;

import com.example.demospringelasticsearch.entity.Product;
import com.example.demospringelasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product insertProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProducts(Product product, Integer id){
        Product product1 =  productRepository.findById(id).get();
        product1.setPrice(product.getPrice());
        return product1;
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
