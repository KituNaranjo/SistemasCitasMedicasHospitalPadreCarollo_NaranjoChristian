package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Especialidad;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.EspecialidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/especialidad")
@CrossOrigin("*")
public class EspecialidadControlador {
    @Autowired
    EspecialidadServicio especialidadServicio;
    @PostMapping("/crear")
    public ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadServicio.guardarEspecialidad(especialidad));
    }
    @GetMapping("/listar")
    public List<Especialidad> listarEspecialidades(){
        return especialidadServicio.listarEspecialidades();
    }
    @GetMapping("/buscar/{especialidad_id}")
    public ResponseEntity<Especialidad> listarEspecialidadesId(@PathVariable("especialidad_id") Integer especialidad_id){
        return ResponseEntity.status(HttpStatus.OK).body(especialidadServicio.obtenerEspecialidadPorId(especialidad_id));
    }
    @DeleteMapping("/eliminar/{especialidad_id}")
    public void eliminarEspecialidad(@PathVariable("especialidad_id") Integer especialidad_id){
        especialidadServicio.eliminarEspecialidadPorId(especialidad_id);
    }
    @PutMapping("/actualizar/{especialidad_id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(@PathVariable("especialidad_id") Integer especialidad_id, @RequestBody Especialidad especialidadActualizada) {
        Especialidad especialidad = especialidadServicio.actualizarEspecialidad(especialidad_id, especialidadActualizada);
        if (especialidad != null) {
            return ResponseEntity.status(HttpStatus.OK).body(especialidad);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
