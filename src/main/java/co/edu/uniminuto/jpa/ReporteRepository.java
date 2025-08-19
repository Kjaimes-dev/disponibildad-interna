package co.edu.uniminuto.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import java.util.List;
import co.edu.uniminuto.dto.EmpleadoDetalleView;
import co.edu.uniminuto.entity.Empleado;

public interface ReporteRepository extends Repository<Empleado, Integer> {
    @Query(value = """
        SELECT e.emp_id as emp_id, e.nombres as nombres, e.apellidos as apellidos, 
               c.nombre_cargo as nombre_cargo, g.nombre_grupo as nombre_grupo, 
               u.username as username, r.role_name as role_name
        FROM empleados e
        JOIN usuarios u ON e.user_id = u.user_id
        JOIN roles r ON u.role_id = r.role_id
        JOIN cargos c ON e.cargo_id = c.cargo_id
        JOIN grupos g ON e.grupo_id = g.grupo_id
    """, nativeQuery = true)
    List<EmpleadoDetalleView> detalleEmpleados();
}