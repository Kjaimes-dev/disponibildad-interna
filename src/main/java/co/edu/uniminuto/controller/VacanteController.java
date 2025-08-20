package co.edu.uniminuto.controller;

import co.edu.uniminuto.entity.Vacante;
import co.edu.uniminuto.jpa.VacanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacantes")
@CrossOrigin
public class VacanteController {
    private final VacanteRepository repo;

    public VacanteController(VacanteRepository repo) { this.repo = repo; }

    @GetMapping
    public ResponseEntity<List<Vacante>> listar() { return ResponseEntity.ok(repo.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        return repo.findById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Vacante v) { return ResponseEntity.ok(repo.save(v)); }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Vacante v) {
        v.setId(id); return ResponseEntity.ok(repo.save(v));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}