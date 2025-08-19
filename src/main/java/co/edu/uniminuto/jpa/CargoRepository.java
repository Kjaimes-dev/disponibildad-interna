package co.edu.uniminuto.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniminuto.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {}
