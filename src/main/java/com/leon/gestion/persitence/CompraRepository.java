package com.leon.gestion.persitence;

import com.leon.gestion.domain.Purchases;
import com.leon.gestion.domain.repository.PurchaseRepository;
import com.leon.gestion.persitence.crud.CompraCrudRepository;
import com.leon.gestion.persitence.entity.Compras;
import com.leon.gestion.persitence.entity.Producto;
import com.leon.gestion.persitence.mapper.PurchasesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchasesMapper purchasesMapper;

    @Override
    public List<Purchases> getAll() {
        return purchasesMapper.toPurchasess((List<Compras>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchases>> getBySuppliers(int supplierId) {
        return compraCrudRepository.findByProveedorId
                (supplierId).map(comprasList -> purchasesMapper.toPurchasess(comprasList));
    }

    @Override
    public Purchases save(Purchases purchases) {
        Compras compras = purchasesMapper.toCompra(purchases);

        compras.getComprasProductos().forEach(comprasProducto -> comprasProducto.setCompras(compras));

        return purchasesMapper.toPurchases(compraCrudRepository.save(compras));
    }
}
