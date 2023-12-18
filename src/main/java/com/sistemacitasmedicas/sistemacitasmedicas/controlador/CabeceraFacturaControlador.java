package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.CabeceraFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.DetalleFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.CabeceraFacturaServicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.DetalleFacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/cabeceraFactura")
@CrossOrigin("*")
public class CabeceraFacturaControlador {
    @Autowired
    CabeceraFacturaServicio cabeceraFacturaServicio;
    @Autowired
    DetalleFacturaServicio detalleFacturaServicio;
    @GetMapping("/obtenerTotalFacturas")
    public ResponseEntity<String> obtenerTotalFacturas() throws Exception{
        List<CabeceraFactura> cabeceraFactura = cabeceraFacturaServicio.findAll();
        double sumaTotal = 0;
        if (cabeceraFactura.isEmpty()){
            throw new Exception("No hay facturas.");
        }
        sumaTotal = cabeceraFactura.stream().mapToDouble(dt -> dt.getTotalFactura()).sum();
        String mensaje = "El total de todas las facturas es: "+sumaTotal;
        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/obtenerTotalServicios")
    public ResponseEntity<String> obtenerTotalServicios() throws Exception {
        List<DetalleFactura> detalleFactura = detalleFacturaServicio.findAll();
        double sumaTotal = 0;
        double sumaSubTotal = 0;
        if(detalleFactura.isEmpty()){
            throw new Exception("No existen detalles facturas servicios.");
        }
        sumaTotal = detalleFactura.stream().mapToDouble(dt -> dt.getTotal()).sum();
        sumaSubTotal = detalleFactura.stream().mapToDouble(dt -> dt.getCabeceraFactura().getSubtotal()).sum();
        String mensaje = "Servicios Contratados: "+sumaTotal+"\n"+
                "Subtotal: "+sumaSubTotal;
        return ResponseEntity.ok(mensaje);
    }
}