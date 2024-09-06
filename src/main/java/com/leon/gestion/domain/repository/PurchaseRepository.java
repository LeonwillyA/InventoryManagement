package com.leon.gestion.domain.repository;

import com.leon.gestion.domain.Purchases;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchases> getAll();
    Optional<List<Purchases>> getBySuppliers(int supplierId);
    Purchases save(Purchases purchases);

}
