package com.leon.gestion.persitence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale_items")
public class VentasProductos {

    @EmbeddedId
    private VentasProductosPK id;

    @Column(name = "quantity")
    private Integer cantidad;

    @Column(name = "price_per_unit")
    private BigDecimal precioUnitario;

    @Column(name = "created_at")
    private LocalDateTime creadoEn;

    @Column(name = "updated_at")
    private LocalDateTime actualizadoEn;

    @ManyToOne
    @JoinColumn(name = "sale_id", insertable = false,updatable = false)
    private Ventas ventas;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Producto producto;

    public VentasProductosPK getId() {
        return id;
    }

    public void setId(VentasProductosPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}
