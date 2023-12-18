package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Servicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servicio")
@CrossOrigin("*")
public class ServicioControlador {
    @Autowired
    ServicioService servicioService;
    @PostMapping("/guardarServicio")
    public Servicio guardarServicio(@RequestBody Servicio servicio){
        return servicioService.save(servicio);
    }
    @PutMapping("/editarServicio/{id}")
    public Servicio editarServicio(@PathVariable Integer id, @RequestBody Servicio servicio) throws Exception{
        Servicio serv = servicioService.obtenerServicioPorServicioId(id);
        if (serv == null){
            throw new Exception("No existe el servicio");
        }
        serv.setNombreServicio(servicio.getNombreServicio());
        serv.setPrecio(servicio.getPrecio());
        serv.setIva(servicio.getIva());
        serv.setCantidad(servicio.getCantidad());
        serv.setEstado(servicio.getEstado());
        return servicioService.update(serv);
    }
    @GetMapping("/obtenerTodosServicios")
    public List<Servicio> obtenerTodosServicios(){
        return servicioService.findAll();
    }
    @GetMapping("/{servicio_id}")
    public Servicio obtenerServicio(@PathVariable("servicio_id") Integer servicio_id){
        return servicioService.obtenerServicioPorServicioId(servicio_id);
    }
    @DeleteMapping("/eliminarServicio/{id}")
    public void eliminarServicio(@PathVariable("id") Integer id){
        servicioService.delete(id);
    }
}
