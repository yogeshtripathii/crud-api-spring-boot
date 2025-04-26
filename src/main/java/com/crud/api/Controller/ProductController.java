package com.crud.api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.Model.ProductList;
import com.crud.api.Repository.ProductRepository;

@RestController
@RequestMapping("api/product")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;


    @PostMapping
    public ResponseEntity<ProductList> createProduct(@RequestBody ProductList prod)
    {
        ProductList saveP=productRepository.save(prod);
        return new ResponseEntity<>(saveP,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ProductList>> getAllProducts() {
        List<ProductList> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductList> getProductById(@PathVariable Long id) {
        Optional<ProductList> product = productRepository.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductList> updateProduct(
        @PathVariable Long id, 
        @RequestBody ProductList updatedProduct) 
    {
        Optional<ProductList> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            updatedProduct.setId(id); // Ensure the ID is set for updating
            ProductList savedProduct = productRepository.save(updatedProduct);
            return new ResponseEntity<>(savedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}



     




