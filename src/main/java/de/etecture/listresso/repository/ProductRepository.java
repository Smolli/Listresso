package de.etecture.listresso.repository;

import de.etecture.listresso.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Spring Data MongoDB repository for the Product entity.
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}
