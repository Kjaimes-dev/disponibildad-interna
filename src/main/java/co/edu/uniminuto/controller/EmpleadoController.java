package co.edu.uniminuto.controller;

import co.edu.uniminuto.dto.EmpleadoRequest;
import co.edu.uniminuto.entity.Empleado;
import co.edu.uniminuto.services.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
@CrossOrigin
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service){ this.service = service; }

    @GetMapping
    public ResponseEntity<?> listar(){ return ResponseEntity.ok(service.listar()); }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id){
        Empleado e = service.obtener(id);
        return (e==null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(e);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody EmpleadoRequest req){
        return ResponseEntity.ok(service.crear(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody EmpleadoRequest req){
        return ResponseEntity.ok(service.actualizar(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
