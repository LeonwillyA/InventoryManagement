package com.leon.gestion.persitence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
public class Clientes {
    @Id
    @Column(name = "id")
    private Integer idClientes;

    private String name;

    @Column(name = "email")
    private String correo;


    @Column(name = "phone_number")
    private String numeroCelular;

    @Column(name="address")
    private String direccion;

    @Column(name = "created_at")
    private LocalDateTime creadoEn;

    @Column(name = "updated_at")
    private LocalDateTime actualizadoEn;

    @OneToMany (mappedBy = "clientes")
    private List<Ventas> ventas;

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}
