package com.leon.gestion.persitence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class VentasProductosPK implements Serializable {
    @Column(name = "sale_id")
    private Integer ventasId;

    @Column(name = "product_id")
    private Integer productosId;

    public Integer getVentasId() {
        return ventasId;
    }

    public void setVentasId(Integer ventasId) {
        this.ventasId = ventasId;
    }

    public Integer getProductosId() {
        return productosId;
    }

    public void setProductosId(Integer productosId) {
        this.productosId = productosId;
    }
}
