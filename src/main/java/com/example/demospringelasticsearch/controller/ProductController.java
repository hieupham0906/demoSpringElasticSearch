package com.example.demospringelasticsearch.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.demospringelasticsearch.entity.Product;
import com.example.demospringelasticsearch.service.ElasticSearchService;
import com.example.demospringelasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apis")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("/findAll")
    public Iterable<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @GetMapping("matchAll")
    public String matchAll() throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.matchAllServices();
        System.out.println("matchAll: " + searchResponse.hits().hits().toString());
        return searchResponse.hits().hits().toString();
    }

    @GetMapping("/matchAllProducts")
    public List<Product> matchAllProducts() throws IOException {
        SearchResponse<Product> searchResponse =  elasticSearchService.matchAllProductsServices();
        System.out.println(searchResponse.hits().hits().toString());
        List<Hit<Product>> listOfHits= searchResponse.hits().hits();
        List<Product> listOfProducts  = new ArrayList<>();
        for(Hit<Product> hit : listOfHits){
            listOfProducts.add(hit.source());
        }
        return listOfProducts;
    }

}
