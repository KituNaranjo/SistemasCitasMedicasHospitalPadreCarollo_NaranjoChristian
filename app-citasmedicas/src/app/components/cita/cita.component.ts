import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CitaService } from 'src/app/services/cita.service';
import { MedicoService } from 'src/app/services/medico.service';
import { ServicioPersonaService } from 'src/app/services/servicio-persona.service';

@Component({
  selector: 'app-cita',
  templateUrl: './cita.component.html',
  styleUrls: ['./cita.component.css']
})
export class CitaComponent {

  personasMedicos: any[] = [];
  personasPacientes: any[] = []; // Debes declarar esta variable

  medico = {
    persona_id: 0, // Id de la persona seleccionada
    medico_id: 0,  // Id del médico seleccionado
  };

  persona = {
    persona_id: 0,
    fechaCita: '', 
    horaCita: ''

  };
  

  constructor( private medicoServicio: MedicoService,private citaServicio: CitaService , private personaServicio: ServicioPersonaService, private router: Router) { }

  ngOnInit() {
    this.obtenerPersonasMedicos();
    this.obtenerPersonasPacientes(); 
  }

  onMedicoSelected() {
    console.log('ID del médico seleccionado:', this.medico.persona_id);

    // Llamar al servicio para obtener el medico_id
    this.medicoServicio.obtenerMedicoPorId(this.medico.persona_id).subscribe(
      (res: any) => {
        this.medico.medico_id = res; // Asignar el medico_id obtenido al objeto medico
        console.log('ID del médico seleccionado:', this.medico.medico_id);
      },
      (error: any) => {
        console.error('Error al obtener el medico_id', error);
      }
    );
  }

  obtenerPersonasMedicos() {
    this.personaServicio.obtenerPersonasMedicos().subscribe(
      (res: any[]) => {
        // Filtrar solo las personas que son médicos (esMedico === true)
        this.personasMedicos = res.filter(medico => medico.esMedico);
        console.log(this.personasMedicos);
      },
      (error: any) => {
        console.error('Error al obtener la lista de médicos', error);
      }
    );
  }

  obtenerPersonasPacientes() {
    this.personaServicio.obtenerPersonasPacientes().subscribe(
      (res: any[]) => {
        // Filtrar solo las personas que son pacientes (esCliente === true)
        this.personasPacientes = res.filter(persona => persona.esCliente);
        console.log(this.personasPacientes);
      },
      (error: any) => {
        console.error('Error al obtener la lista de pacientes', error);
      }
    );
  }


  form_register() {
    const fechaCitaFormatted = this.formatDate(this.persona.fechaCita);
    const horaCitaFormatted = this.formatTime(this.persona.horaCita);

    this.citaServicio.registrarCita(
      this.medico.medico_id,
      this.persona.persona_id,
      fechaCitaFormatted,
      horaCitaFormatted
    ).subscribe(
      (response: any) => {
        console.log('Cita creada correctamente', response);
        // Aquí puedes redirigir o mostrar un mensaje de éxito si lo deseas
      },
      (error: any) => {
        console.error('Error al crear la cita', error);
        // Aquí puedes mostrar un mensaje de error si lo deseas
      }
    );
  }

  formatDate(date: string): string {
    // Convierte la cadena de fecha en formato "yyyy-MM-dd" (ISO 8601) al formato "dd-MM-yyyy" (backend)
    const dateParts = date.split('-');
    return `${dateParts[2]}-${dateParts[1]}-${dateParts[0]}`;
  }

  formatTime(time: string): string {
    // Convierte la cadena de hora en formato "HH:mm" al formato "HH:mm:ss.sss" (backend)
    return `${time}:00.000`;
  }



}