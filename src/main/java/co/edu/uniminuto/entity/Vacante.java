package co.edu.uniminuto.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacantes")
public class Vacante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacante_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String requisitos;

    private LocalDate fechaPublicacion;
    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.abierta;

    public enum Estado { abierta, cerrada, pausada }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRequisitos() { return requisitos; }
    public void setRequisitos(String requisitos) { this.requisitos = requisitos; }

    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}