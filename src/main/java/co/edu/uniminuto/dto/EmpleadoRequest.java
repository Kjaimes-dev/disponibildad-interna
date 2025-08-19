package co.edu.uniminuto.dto;

import java.math.BigDecimal;

public class EmpleadoRequest {
    public Integer userId; // opcional si lo ligas a un usuario ya creado
    public String tipoDocumento;
    public String numeroDocumento;
    public String nombres;
    public String apellidos;
    public String celular;
    public String correo;
    public String direccion;
    public String fechaNacimiento; // "YYYY-MM-DD"
    public String fechaIngreso;    // "YYYY-MM-DD"
    public BigDecimal salario;
    public Integer cargoId;
    public Integer grupoId;
}
