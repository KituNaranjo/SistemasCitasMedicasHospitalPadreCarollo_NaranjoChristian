import { Component, OnInit } from '@angular/core';
import { MedicoService } from 'src/app/services/medico.service';
import { ClinicaService } from 'src/app/services/clinica.service';
import { ServicioPersonaService } from 'src/app/services/servicio-persona.service';

@Component({
  selector: 'app-clinica',
  templateUrl: './clinica.component.html',
  styleUrls: ['./clinica.component.css']
})
export class ClinicaComponent implements OnInit {
  public personas: any[] = [];
  public medicos: any[] = [];
  public clinica = {
    medico_id: 0,
    persona_id: 0,
    prescripciones: '',
    ordenes: '',
    certificados: ''
  };

  constructor(
    private clinicaService: ClinicaService,
    private servicioPersonaService: ServicioPersonaService,
    private medicoService: MedicoService
  ) {}

  ngOnInit() {
    this.obtenerClientes();
    this.obtenerMedicos();
  }

  obtenerClientes() {
    this.servicioPersonaService.obtenerPersonasMedicos().subscribe(
      (res: any[]) => {
        // Filtrar solo las personas que son clientes (esCliente === true)
        this.personas = res.filter(persona => persona.esCliente === true);
        console.log(this.personas);
      },
      (error: any) => {
        console.error('Error al obtener la lista de clientes', error);
      }
    );
  }
  
  obtenerMedicos() {
    this.medicoService.obtenerMedicos().subscribe(
      (res: any[]) => {
        this.medicos = res;
        console.log(this.medicos);
      },
      (error: any) => {
        console.error('Error al obtener la lista de médicos', error);
      }
    );
  }

  form_register() {
    console.log('Si está pasando');
    // Llamar al servicio registrarClinica para guardar la clínica
    this.clinicaService.registrarClinica(
      this.clinica.medico_id,
      this.clinica.persona_id,
      this.clinica.prescripciones,
      this.clinica.ordenes,
      this.clinica.certificados
    ).subscribe(
      (response: any) => {
        // Manejar la respuesta del backend si es necesario
        console.log('Historia clínica registrada correctamente', response);
      },
      (error: any) => {
        // Manejar el error si ocurre
        console.error('Error al registrar Historia clínica', error);
      }
    );
  }

  seleccionarPersona(persona: any) {
    this.clinica.persona_id = persona.persona_id;
  }
}