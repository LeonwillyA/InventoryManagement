package com.leon.gestion.persitence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idProducto;

    private String name;

    private String description;

    private Double price;

    @Column(name="sku")
    private String codigoBarras;

    @Column(name = "category_id")
    private Integer idCategoria;

    @Column(name = "stock_quantity")
    private Integer stockUnidades;

    @Column(name = "created_at")
    private LocalDateTime creadoEn;

    @Column(name = "updated_at")
    private LocalDateTime actualizadoEn;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Categorias categorias;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getStockUnidades() {
        return stockUnidades;
    }

    public void setStockUnidades(Integer stockUnidades) {
        this.stockUnidades = stockUnidades;
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