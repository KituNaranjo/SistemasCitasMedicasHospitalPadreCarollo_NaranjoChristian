package com.sistemacitasmedicas.sistemacitasmedicas.controlador;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.CabeceraFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.DetalleFactura;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Persona;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Servicio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturaControlador")
@CrossOrigin("*")
public class FacturaControlador {
    @Autowired
    private CabeceraFacturaServicio cabeceraFacturaServicio;
    @Autowired
    private DetalleFacturaServicio detalleFacturaServicio;
    @Autowired
    private PersonaServicio personaServicio;
    @Autowired
    private ServicioService servicioService;
    @Autowired
    private EmailSenderServicio emailSenderServicio;
    @PostMapping("/crear/{persona_id}/{servicio_id}/{cantidad}")
    public ResponseEntity<?> crearFactura(@PathVariable Integer persona_id,
                                          @PathVariable Integer servicio_id,
                                          @PathVariable int cantidad) {
        try {
            Persona personaOptional = personaServicio.obtenerPersonaPorId(persona_id);
            Optional<Servicio> servicioOptional = servicioService.get(servicio_id);
            if (personaOptional == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("La persona con el ID " + persona_id + " no existe.");
            }
            if (!servicioOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El servicio con el ID " + servicio_id + " no existe.");
            }
            CabeceraFactura cabeceraFactura = new CabeceraFactura();
            cabeceraFactura.setFecha(new Date());
            cabeceraFactura.setEstado(true);
            cabeceraFactura.setPersona(personaOptional);
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setCantidad(cantidad);
            detalleFactura.setNombre(servicioOptional.get().getNombreServicio());
            detalleFactura.setPrecioUnitario(servicioOptional.get().getPrecio());
            detalleFactura.setTotal(cantidad * servicioOptional.get().getPrecio());
            detalleFactura.setServicio(servicioOptional.get());
            detalleFactura.setCabeceraFactura(cabeceraFactura);
            double subtotal = detalleFactura.getTotal();
            double totalIva = subtotal * servicioOptional.get().getIva();
            double totalFactura = subtotal + totalIva;
            cabeceraFactura.setSubtotal(subtotal);
            cabeceraFactura.setTotalIva(totalIva);
            cabeceraFactura.setTotalFactura(totalFactura);
            Servicio servicio = servicioOptional.get();
            if (servicio.getCantidad() == 0){
                throw new Exception("No esta ese servicio disponible");
            }
            int cantidadServicio = servicioOptional.get().getCantidad() - cantidad;
            servicio.setCantidad(cantidadServicio);
            servicioService.update(servicio);
            cabeceraFacturaServicio.save(cabeceraFactura);
            detalleFacturaServicio.save(detalleFactura);
            String toUser = personaOptional.getCorreo();
            String subject = "Factura creada";
            StringBuffer content = new StringBuffer();
            content.append("Factura sistema citas medicas");
            content.append("\n");
            content.append("\n");
            content.append("Datos de la persona:");
            content.append("\n");
            content.append("Nombre: " + personaOptional.getNombre());
            content.append("\n");
            content.append("Apellido: " + personaOptional.getApellido());
            content.append("\n");
            content.append("Email: " + personaOptional.getCorreo());
            content.append("\n");
            content.append("\n");
            content.append("Detalles de la factura:");
            content.append("\n");
            content.append("Nombre: " + servicioOptional.get().getNombreServicio());
            content.append("\n");
            content.append("Cantidad: "+ cantidad);
            content.append("\n");
            content.append("Subtotal: " + subtotal);
            content.append("\n");
            content.append("Total IVA: " + totalIva);
            content.append("\n");
            content.append("Total factura: " + totalFactura);
            content.append("\n");
            emailSenderServicio.sendEmail(toUser, subject, content);
            return ResponseEntity.ok("La factura se ha creado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al crear la factura: " + e.getMessage());
        }
    }
    @GetMapping("/obtenerFacturas")
    public List<CabeceraFactura> obtenerFacturas() {
        return cabeceraFacturaServicio.findAll();
    }
    @GetMapping("/{servicio_id}")
    public CabeceraFactura obtenerFacturaPorId(@PathVariable Integer servicio_id){
        return cabeceraFacturaServicio.obtenerCabeceraFacturaPorId(servicio_id);
    }
}