package co.edu.uniminuto.controller;

import co.edu.uniminuto.entity.Cargo;
import co.edu.uniminuto.entity.Grupo;
import co.edu.uniminuto.jpa.CargoRepository;
import co.edu.uniminuto.jpa.GrupoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class CatalogosController {

    private final CargoRepository cargos;
    private final GrupoRepository grupos;

    public CatalogosController(CargoRepository cargos, GrupoRepository grupos){
        this.cargos = cargos;
        this.grupos = grupos;
    }

    // CARGOS
    @GetMapping("/cargos")
    public ResponseEntity<?> listCargos(){ return ResponseEntity.ok(cargos.findAll()); }

    @GetMapping("/cargos/{id}")
    public ResponseEntity<?> getCargo(@PathVariable Integer id){
        return cargos.findById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cargos")
    public ResponseEntity<?> createCargo(@RequestBody Cargo c){ return ResponseEntity.ok(cargos.save(c)); }

    @PutMapping("/cargos/{id}")
    public ResponseEntity<?> updateCargo(@PathVariable Integer id, @RequestBody Cargo c){
        c.setId(id); return ResponseEntity.ok(cargos.save(c));
    }

    @DeleteMapping("/cargos/{id}")
    public ResponseEntity<?> deleteCargo(@PathVariable Integer id){
        cargos.deleteById(id); return ResponseEntity.noContent().build();
    }

    // GRUPOS
    @GetMapping("/grupos")
    public ResponseEntity<?> listGrupos(){ return ResponseEntity.ok(grupos.findAll()); }

    @GetMapping("/grupos/{id}")
    public ResponseEntity<?> getGrupo(@PathVariable Integer id){
        return grupos.findById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/grupos")
    public ResponseEntity<?> createGrupo(@RequestBody Grupo g){ return ResponseEntity.ok(grupos.save(g)); }

    @PutMapping("/grupos/{id}")
    public ResponseEntity<?> updateGrupo(@PathVariable Integer id, @RequestBody Grupo g){
        g.setId(id); return ResponseEntity.ok(grupos.save(g));
    }

    @DeleteMapping("/grupos/{id}")
    public ResponseEntity<?> deleteGrupo(@PathVariable Integer id){
        grupos.deleteById(id); return ResponseEntity.noContent().build();
    }
}
