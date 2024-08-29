package com.leon.gestion.persitence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idVentas;

    @Column(name = "sale_date")
    private LocalDateTime fechaVenta;

    @Column(name = "customer_id")
    private Integer clienteId;

    @Column(name = "total_amount")
    private BigDecimal montoAcumulado;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime creadoEn;

    @Column(name = "updated_at")
    private LocalDateTime actualizadoEn;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Clientes clientes;

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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
