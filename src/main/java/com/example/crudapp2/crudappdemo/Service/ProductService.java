package com.example.crudapp2.crudappdemo.Service;


import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import com.example.crudapp2.crudappdemo.Entity.Product;
import com.example.crudapp2.crudappdemo.Repository.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.Expression;


@Service
public class ProductService {
	
    @Autowired
    private ProductRepository repository;

    
    @Autowired
    EntityManager entityManager;

    public Product saveProduct(Product product) {
    	
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
    	Query query = entityManager.createQuery("From Product p where p.id = 2");
    
    	List list = query.getResultList();
    	System.out.println("query:" + list);
//        return repository.findAll();
    	return list;
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

	public List<Product> getProductByproductType(String productType) {
		List<Product> productList = repository.findAll();
		System.out.println("list of all products:"+ productList);
		List<Product> newList = productList.stream().filter(product -> product.getProductType().equals(productType))
				.collect(Collectors.toList());
		System.out.println("new list of all products:"+ newList);
		return newList;
	}


}
