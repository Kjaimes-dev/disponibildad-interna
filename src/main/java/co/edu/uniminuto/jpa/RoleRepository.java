package co.edu.uniminuto.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniminuto.entity.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
