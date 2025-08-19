package co.edu.uniminuto.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniminuto.entity.Empleado;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Optional<Empleado> findByNumeroDocumento(String numeroDocumento);
}
