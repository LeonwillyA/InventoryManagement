package com.leon.gestion.persitence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer productoId;

    @Column(name = "name")
    private String nombre;

    @Column(name = "description")
    private String descripcion;

    @Column(name="price")
    private BigDecimal precio;

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

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.ALL})
    private List<ComprasProducto> comprasProductos;

    @OneToMany(mappedBy = "producto")
    private List<MovimientoInventario> movimientoInventarios;

    @OneToMany(mappedBy = "producto")
    private List<VentasProductos> ventasProductos;

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public List<MovimientoInventario> getMovimientoInventarios() {
        return movimientoInventarios;
    }

    public void setMovimientoInventarios(List<MovimientoInventario> movimientoInventarios) {
        this.movimientoInventarios = movimientoInventarios;
    }

    public List<ComprasProducto> getComprasProductos() {
        return comprasProductos;
    }

    public void setComprasProductos(List<ComprasProducto> comprasProductos) {
        this.comprasProductos = comprasProductos;
    }

    public List<VentasProductos> getVentasProductos() {
        return ventasProductos;
    }

    public void setVentasProductos(List<VentasProductos> ventasProductos) {
        this.ventasProductos = ventasProductos;
    }
}