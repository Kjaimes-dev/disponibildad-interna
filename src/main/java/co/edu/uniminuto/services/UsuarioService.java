package co.edu.uniminuto.services;

import co.edu.uniminuto.entity.Role;
import co.edu.uniminuto.entity.Usuario;
import co.edu.uniminuto.jpa.RoleRepository;
import co.edu.uniminuto.jpa.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarios;
    private final RoleRepository roles;

    public UsuarioService(UsuarioRepository usuarios, RoleRepository roles) {
        this.usuarios = usuarios;
        this.roles = roles;
    }

    public List<Usuario> listar(){ return usuarios.findAll(); }

    public Usuario obtener(Integer id){
        return usuarios.findById(id).orElse(null);
    }

    @Transactional
    public Usuario crear(Usuario u){
        // Validaciones simples
        usuarios.findByUsername(u.getUsername()).ifPresent(x -> { throw new RuntimeException("username ya existe"); });
        usuarios.findByEmail(u.getEmail()).ifPresent(x -> { throw new RuntimeException("email ya existe"); });

        if(u.getRole()==null){
            Role rolUsuario = roles.findByName("Usuario").orElseThrow();
            u.setRole(rolUsuario);
        }
        // TODO: hashear password (BCrypt) en siguiente iteración
        return usuarios.save(u);
    }

    @Transactional
    public Usuario actualizar(Integer id, String email, String status){
        Usuario u = usuarios.findById(id).orElseThrow();
        if(email!=null) u.setEmail(email);
        if(status!=null) u.setStatus(Usuario.Status.valueOf(status));
        return usuarios.save(u);
    }

    @Transactional
    public void eliminar(Integer id){
        usuarios.deleteById(id);
    }

    @Transactional
    public Usuario cambiarRol(Integer id, Integer roleId){
        Usuario u = usuarios.findById(id).orElseThrow();
        Role r = roles.findById(roleId).orElseThrow();
        u.setRole(r);
        return usuarios.save(u);
    }

    public Usuario buscarPorUsername(String username){
        return usuarios.findByUsername(username).orElse(null);
    }
}
