package co.edu.uniminuto.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniminuto.entity.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {}