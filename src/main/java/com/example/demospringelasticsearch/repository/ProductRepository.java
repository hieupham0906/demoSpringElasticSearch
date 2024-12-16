package com.example.demospringelasticsearch.repository;

import com.example.demospringelasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {
}
