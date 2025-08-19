package co.edu.uniminuto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
    private Integer id;

    @Column(name = "nombre_cargo", nullable = false, length = 100)
    private String nombre;

    @Lob
    private String requisitos;

    // getters/setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getRequisitos(){ return requisitos; }
    public void setRequisitos(String requisitos){ this.requisitos = requisitos; }
}
