package com.leon.gestion.web.controller;

import com.leon.gestion.domain.Sales;
import com.leon.gestion.domain.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/all")
    public ResponseEntity<List<Sales>> getAll(){
        return new ResponseEntity<List<Sales>>(saleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/cliente/{customerId}")
    public ResponseEntity<List<Sales>> getByCustomer(@PathVariable("customerId") String customerId){
        return saleService.getByCustomer(customerId).map(sales -> new ResponseEntity<>(sales, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Sales> save(@RequestBody Sales sales){
        return new ResponseEntity<>(saleService.save(sales),HttpStatus.CREATED);
    }
}
