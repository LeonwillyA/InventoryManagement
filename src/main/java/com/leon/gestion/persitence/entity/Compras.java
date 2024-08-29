package com.leon.gestion.persitence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idCompras;

    @Column(name = "purchase_date")
    private LocalDateTime fechaCompra;

    @Column(name = "supplier_id")
    private Integer proveedorId;

    @Column(name = "total_amount")
    private BigDecimal montoAcumulado;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime creadoEn;

    @Column(name = "updated_at")
    private LocalDateTime actualizadoEn;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private Proveedores proveedores;

    public Integer getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(Integer idCompras) {
        this.idCompras = idCompras;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public BigDecimal getMontoAcumulado() {
        return montoAcumulado;
    }

    public void setMontoAcumulado(BigDecimal montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
