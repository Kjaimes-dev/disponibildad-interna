package co.edu.uniminuto.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "postulaciones")
public class Postulacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vacante_id", nullable = false)
    private Vacante vacante;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Empleado empleado; // Si es interno

    private String nombreCandidato; // Si es externo
    private String correoCandidato;

    private LocalDate fechaPostulacion;
    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.en_proceso;

    public enum Estado { en_proceso, rechazado, aceptado }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Vacante getVacante() { return vacante; }
    public void setVacante(Vacante vacante) { this.vacante = vacante; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public String getNombreCandidato() { return nombreCandidato; }
    public void setNombreCandidato(String nombreCandidato) { this.nombreCandidato = nombreCandidato; }

    public String getCorreoCandidato() { return correoCandidato; }
    public void setCorreoCandidato(String correoCandidato) { this.correoCandidato = correoCandidato; }

    public LocalDate getFechaPostulacion() { return fechaPostulacion; }
    public void setFechaPostulacion(LocalDate fechaPostulacion) { this.fechaPostulacion = fechaPostulacion; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}