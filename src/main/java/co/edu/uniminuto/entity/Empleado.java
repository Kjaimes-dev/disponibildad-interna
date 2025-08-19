package co.edu.uniminuto.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;

    // Relación 1:1 con Usuario (user_id UNIQUE en la tabla)
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private Usuario usuario;

    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, unique = true, length = 50)
    private String numeroDocumento;

    @Column(nullable = false, length = 150)
    private String nombres;

    @Column(nullable = false, length = 150)
    private String apellidos;

    @Column(length = 20)
    private String celular;

    @Column(nullable = false, length = 150)
    private String correo;

    @Column(length = 255)
    private String direccion;

    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    @Column(precision = 12, scale = 2)
    private BigDecimal salario;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    // getters/setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public Usuario getUsuario(){ return usuario; }
    public void setUsuario(Usuario usuario){ this.usuario = usuario; }
    public String getTipoDocumento(){ return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento){ this.tipoDocumento = tipoDocumento; }
    public String getNumeroDocumento(){ return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento){ this.numeroDocumento = numeroDocumento; }
    public String getNombres(){ return nombres; }
    public void setNombres(String nombres){ this.nombres = nombres; }
    public String getApellidos(){ return apellidos; }
    public void setApellidos(String apellidos){ this.apellidos = apellidos; }
    public String getCelular(){ return celular; }
    public void setCelular(String celular){ this.celular = celular; }
    public String getCorreo(){ return correo; }
    public void setCorreo(String correo){ this.correo = correo; }
    public String getDireccion(){ return direccion; }
    public void setDireccion(String direccion){ this.direccion = direccion; }
    public LocalDate getFechaNacimiento(){ return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento){ this.fechaNacimiento = fechaNacimiento; }
    public LocalDate getFechaIngreso(){ return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso){ this.fechaIngreso = fechaIngreso; }
    public BigDecimal getSalario(){ return salario; }
    public void setSalario(BigDecimal salario){ this.salario = salario; }
    public Cargo getCargo(){ return cargo; }
    public void setCargo(Cargo cargo){ this.cargo = cargo; }
    public Grupo getGrupo(){ return grupo; }
    public void setGrupo(Grupo grupo){ this.grupo = grupo; }
}
