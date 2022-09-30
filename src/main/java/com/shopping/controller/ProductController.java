package com.shopping.controller;

import com.shopping.model.Product;
import com.shopping.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")


public class ProductController {

    private ProductRepository productRepository;

    ProductController(ProductRepository productRep){
            productRepository=productRep;

    }


    @GetMapping("")
    public List<Product> getProducts(@RequestParam(name = "name") String name) {
        if(name.equals("products") || name.equals("")) {

            return productRepository.findAll();
        }else {
            return productRepository.findByName(name);
        }


    }

    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam(name = "name") String category) {

        return  productRepository.findByCategoryName(category);
    }

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody Product productRequest){
        productRepository.save(productRequest);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam (name="id") int id){
        productRepository.deleteById(id);

    }


}
