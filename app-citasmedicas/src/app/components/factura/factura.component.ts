import { FacturaService } from './../../services/factura.service';
import { Component } from '@angular/core';
import { ServicioPersonaService } from 'src/app/services/servicio-persona.service';
import { ServiciosService } from 'src/app/services/servicios.service';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent {
  public servicio: any[] = [];
  public personas: any[] = [];

  public factura = {
    personaId: 0,
    servicioId: 0,
    cantidad: 0
  };

  constructor(
    private facturaService: FacturaService,
    private servicioPersonaService: ServicioPersonaService,
    private serviciosService: ServiciosService
  ) {}

  ngOnInit(){
    this.obtenerClientes();
    this.obtenerServicios();
  }

  obtenerServicios() {
    this.serviciosService.obtenerTodosServicios().subscribe(
      (res: any[]) => {
        this.servicio = res;
        console.log(res);
      },
      (error: any) => {
        console.error('Error al obtener servicios', error);
      }
    );
  }

  obtenerClientes() {
    this.servicioPersonaService.obtenerPersonasMedicos().subscribe(
      (res: any[]) => {
        // Filtrar solo las personas que son clientes (esMedico === false)
        this.personas = res.filter(persona => !persona.esEmpleado);
        console.log(this.personas);
      },
      (error: any) => {
        console.error('Error al obtener la lista de clientes', error);
      }
    );
  }

  form_register() {
    // Llamar al servicio registrarMedico para guardar el médico con su especialidad
    this.facturaService.crearFacturas(this.factura.personaId, this.factura.servicioId,
       this.factura.cantidad).subscribe(
      (response: any) => {
        // Manejar la respuesta del backend si es necesario
        console.log('Factura registrada correctamente', response);
      },
      (error: any) => {
        // Manejar el error si ocurre
        console.error('Error al registrar factura', error);
      }
    );
  }

  seleccionarPersona(persona: any) {
    this.factura.personaId = persona.id;
  }

  seleccionarServicio(servicio: any) {
    this.factura.servicioId = servicio.id;
  }
}