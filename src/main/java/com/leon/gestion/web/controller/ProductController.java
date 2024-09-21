package com.leon.gestion.web.controller;

import com.leon.gestion.domain.Product;
import com.leon.gestion.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @Operation( summary = "Get all miniMarket products")
    @ApiResponse(responseCode = "200", description = "ok")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{productId}")
    @Operation(summary = "Search a product by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "404", description = "Product NOT FOUND"),
    })
    public ResponseEntity<Product> getProduct(@Parameter(description = "The id of the product", required = true, example = "2") @PathVariable("productId") int productId){
        return productService.getProduct(productId).
                map(product -> new ResponseEntity<>(product, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @GetMapping("/categoria/{categoryId}")
    @Operation(summary = "Search a products by Category")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId).
                map(products -> new ResponseEntity<>(products, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    @Operation(summary = "Save a new product")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "Delete a product")
    public ResponseEntity delete(@PathVariable("productId") int prouctId){
        if (productService.delete(prouctId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
