package co.edu.uniminuto.controller;

import co.edu.uniminuto.dto.LoginRequest;
import co.edu.uniminuto.dto.LoginResponse;
import co.edu.uniminuto.dto.RegisterRequest;
// import co.edu.uniminuto.entity.Role;
import co.edu.uniminuto.entity.Usuario;
import co.edu.uniminuto.jpa.RoleRepository;
import co.edu.uniminuto.security.JwtUtil;
import co.edu.uniminuto.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UsuarioService usuarios;
    private final RoleRepository roles;

    public AuthController(UsuarioService usuarios, RoleRepository roles) {
        this.usuarios = usuarios;
        this.roles = roles;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        Usuario u = usuarios.buscarPorUsername(req.username);
        if(u == null || !u.getPassword().equals(req.password)) { // TODOh: BCrypt
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
        String token = JwtUtil.generateToken(u.getUsername());
        return ResponseEntity.ok(new LoginResponse(
            u.getId(),
            u.getUsername(),
            u.getEmail(),
            u.getRole().getName(),
            u.getStatus().name(),
            token
        ));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req){
        Usuario u = new Usuario();
        u.setUsername(req.username);
        u.setEmail(req.email);
        u.setPassword(req.password);
        // por defecto rol "Usuario"
        roles.findByName("Usuario").ifPresent(u::setRole);
        return ResponseEntity.ok(usuarios.crear(u));
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(){
        // Placeholder: sin seguridad real, devolver un ejemplo
        return ResponseEntity.ok("Implementar con JWT");
    }
}
