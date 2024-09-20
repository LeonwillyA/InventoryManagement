package com.leon.gestion.web.controller;


import com.leon.gestion.domain.Purchases;
import com.leon.gestion.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchases>> getAll(){
        return new ResponseEntity<List<Purchases>>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/proveedor/{categoryId}")
    public ResponseEntity<List<Purchases>> getBySupplier(@PathVariable("categoryId") int categoryId){
        return purchaseService.getBySuppliers(categoryId).map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchases> save (@RequestBody Purchases purchases){
        return new ResponseEntity<>(purchaseService.save(purchases), HttpStatus.CREATED);
    }


}
