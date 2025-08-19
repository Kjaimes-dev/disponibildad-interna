package co.edu.uniminuto.services;

import co.edu.uniminuto.dto.EmpleadoRequest;
import co.edu.uniminuto.entity.*;
import co.edu.uniminuto.jpa.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleados;
    private final UsuarioRepository usuarios;
    private final CargoRepository cargos;
    private final GrupoRepository grupos;

    public EmpleadoService(EmpleadoRepository empleados, UsuarioRepository usuarios,
                           CargoRepository cargos, GrupoRepository grupos) {
        this.empleados = empleados;
        this.usuarios = usuarios;
        this.cargos = cargos;
        this.grupos = grupos;
    }

    public List<Empleado> listar(){ return empleados.findAll(); }

    public Empleado obtener(Integer id){ return empleados.findById(id).orElse(null); }

    @Transactional
    public Empleado crear(EmpleadoRequest req){
        Empleado e = new Empleado();
        if(req.userId != null){
            e.setUsuario(usuarios.findById(req.userId).orElse(null));
        }
        e.setTipoDocumento(req.tipoDocumento);
        e.setNumeroDocumento(req.numeroDocumento);
        e.setNombres(req.nombres);
        e.setApellidos(req.apellidos);
        e.setCelular(req.celular);
        e.setCorreo(req.correo);
        e.setDireccion(req.direccion);
        if(req.fechaNacimiento!=null) e.setFechaNacimiento(LocalDate.parse(req.fechaNacimiento));
        if(req.fechaIngreso!=null) e.setFechaIngreso(LocalDate.parse(req.fechaIngreso));
        e.setSalario(req.salario);
        if(req.cargoId!=null) e.setCargo(cargos.findById(req.cargoId).orElse(null));
        if(req.grupoId!=null) e.setGrupo(grupos.findById(req.grupoId).orElse(null));
        return empleados.save(e);
    }

    @Transactional
    public Empleado actualizar(Integer id, EmpleadoRequest req){
        Empleado e = empleados.findById(id).orElseThrow();
        if(req.userId!=null) e.setUsuario(usuarios.findById(req.userId).orElse(null));
        if(req.tipoDocumento!=null) e.setTipoDocumento(req.tipoDocumento);
        if(req.numeroDocumento!=null) e.setNumeroDocumento(req.numeroDocumento);
        if(req.nombres!=null) e.setNombres(req.nombres);
        if(req.apellidos!=null) e.setApellidos(req.apellidos);
        if(req.celular!=null) e.setCelular(req.celular);
        if(req.correo!=null) e.setCorreo(req.correo);
        if(req.direccion!=null) e.setDireccion(req.direccion);
        if(req.fechaNacimiento!=null) e.setFechaNacimiento(LocalDate.parse(req.fechaNacimiento));
        if(req.fechaIngreso!=null) e.setFechaIngreso(LocalDate.parse(req.fechaIngreso));
        if(req.salario!=null) e.setSalario(req.salario);
        if(req.cargoId!=null) e.setCargo(cargos.findById(req.cargoId).orElse(null));
        if(req.grupoId!=null) e.setGrupo(grupos.findById(req.grupoId).orElse(null));
        return empleados.save(e);
    }

    @Transactional
    public void eliminar(Integer id){ empleados.deleteById(id); }
}
