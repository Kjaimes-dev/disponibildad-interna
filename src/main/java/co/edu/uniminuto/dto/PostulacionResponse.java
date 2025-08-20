package co.edu.uniminuto.dto;

import java.time.LocalDate;

public class PostulacionResponse {
    public Integer id;
    public Integer vacanteId;
    public String vacanteDescripcion;
    public Integer empleadoId;
    public String nombreCandidato;
    public String correoCandidato;
    public LocalDate fechaPostulacion;
    public String estado;
}