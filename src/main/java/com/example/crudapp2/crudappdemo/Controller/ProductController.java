package com.example.crudapp2.crudappdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudapp2.crudappdemo.Entity.Product;
import com.example.crudapp2.crudappdemo.Exception.ProductNotFoundException;
import com.example.crudapp2.crudappdemo.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/crudapp")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping(value ="/products", produces = {"application/json","application/xml"} )
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
    	if(id==1) throw new ProductNotFoundException("product Not available with this :" + id);
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }
    
    @GetMapping("/products/filter")
    public ResponseEntity<?> findProduct(@RequestParam(value="productType" ,required=false) @Valid String productType) {
    	List<Product> list  =	(productType != null)
    								? service.getProductByproductType(productType) 
    								: service.getProducts();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/productByType/{productType}")
    public List<Product> findProductByProductType(@PathVariable String productType) {
        return service.getProductByproductType(productType);
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
