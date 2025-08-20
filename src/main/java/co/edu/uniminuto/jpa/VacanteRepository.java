package co.edu.uniminuto.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniminuto.entity.Vacante;

public interface VacanteRepository extends JpaRepository<Vacante, Integer> {}