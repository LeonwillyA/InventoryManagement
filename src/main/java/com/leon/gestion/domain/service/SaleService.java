package com.leon.gestion.domain.service;

import com.leon.gestion.domain.Sales;
import com.leon.gestion.domain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sales> getAll(){
        return saleRepository.getAll();
    }

    public Optional<List<Sales>> getByCustomer(String customerId){
        return saleRepository.getByCustomers(customerId);
    }

    public Sales save(Sales sales){
        return saleRepository.save(sales);
    }
}
