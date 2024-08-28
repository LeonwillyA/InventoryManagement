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

    private double price;

    @Column(name="sku")
    private String codigoBarras;

    @Column(name = "category_id")
    private Integer idCategoria;

    @Column(name = "stock_quantity")
    private int stockUnidades;

    @Column(name = "created_at")
    private LocalDateTime creadoEn;

    @Column(name = "updated_at")
    private LocalDateTime actualizadoEn;
}