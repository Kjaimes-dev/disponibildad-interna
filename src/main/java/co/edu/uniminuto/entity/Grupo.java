package co.edu.uniminuto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grupos")
public class Grupo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grupo_id")
    private Integer id;

    @Column(name = "nombre_grupo", nullable = false, length = 100)
    private String nombre;

    // getters/setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
}
