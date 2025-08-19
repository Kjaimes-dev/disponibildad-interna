package co.edu.uniminuto.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniminuto.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
}
