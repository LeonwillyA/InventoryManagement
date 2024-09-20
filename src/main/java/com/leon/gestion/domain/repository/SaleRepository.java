package com.leon.gestion.domain.repository;

import com.leon.gestion.domain.Sales;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    List<Sales> getAll();
    Optional<List<Sales>> getByCustomers(String customerId);
    Sales save(Sales sales);
}
