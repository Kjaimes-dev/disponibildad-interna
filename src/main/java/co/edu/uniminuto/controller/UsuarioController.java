package co.edu.uniminuto.controller;

import co.edu.uniminuto.dto.UpdateRoleRequest;
import co.edu.uniminuto.dto.UpdateUsuarioRequest;
import co.edu.uniminuto.entity.Usuario;
import co.edu.uniminuto.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service){ this.service = service; }

    @GetMapping
    public ResponseEntity<?> listar(){ return ResponseEntity.ok(service.listar()); }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id){
        Usuario u = service.obtener(id);
        return (u==null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(u);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Usuario u){
        return ResponseEntity.ok(service.crear(u));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody UpdateUsuarioRequest req){
        return ResponseEntity.ok(service.actualizar(id, req.email, req.status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/rol")
    public ResponseEntity<?> cambiarRol(@PathVariable Integer id, @RequestBody UpdateRoleRequest req){
        return ResponseEntity.ok(service.cambiarRol(id, req.roleId));
    }
}
