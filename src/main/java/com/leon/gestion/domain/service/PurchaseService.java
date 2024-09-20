package com.leon.gestion.domain.service;

import com.leon.gestion.domain.Product;
import com.leon.gestion.domain.Purchases;
import com.leon.gestion.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchases> getAll(){
        return purchaseRepository.getAll();
    }


    public Optional<List<Purchases>> getBySuppliers(int supplierId){
        return purchaseRepository.getBySuppliers(supplierId);
    }

    public Purchases save(Purchases purchases){
        return purchaseRepository.save(purchases);
    }
}
