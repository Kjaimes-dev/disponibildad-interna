package co.edu.uniminuto.controller;

import co.edu.uniminuto.entity.Postulacion;
import co.edu.uniminuto.jpa.PostulacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postulaciones")
@CrossOrigin
public class PostulacionController {
    private final PostulacionRepository repo;

    public PostulacionController(PostulacionRepository repo) { this.repo = repo; }

    @GetMapping
    public ResponseEntity<List<Postulacion>> listar() { return ResponseEntity.ok(repo.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        return repo.findById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Postulacion p) { return ResponseEntity.ok(repo.save(p)); }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Postulacion p) {
        return repo.findById(id)
            .map(post -> {
                if (p.getEstado() != null) post.setEstado(p.getEstado());
                if (p.getVacante() != null) post.setVacante(p.getVacante());
                if (p.getEmpleado() != null) post.setEmpleado(p.getEmpleado());
                if (p.getNombreCandidato() != null) post.setNombreCandidato(p.getNombreCandidato());
                if (p.getCorreoCandidato() != null) post.setCorreoCandidato(p.getCorreoCandidato());
                if (p.getFechaPostulacion() != null) post.setFechaPostulacion(p.getFechaPostulacion());
                return ResponseEntity.ok(repo.save(post));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}