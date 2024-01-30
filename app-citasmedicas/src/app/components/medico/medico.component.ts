import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EspecialidadesService } from 'src/app/services/especialidades.service';
import { MedicoService } from 'src/app/services/medico.service';
import { ServicioPersonaService } from 'src/app/services/servicio-persona.service';

@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.css']
})
export class MedicoComponent {

  personasMedicos: any[] = [];
  especialidades: any[] = [];

  medico = {
    telenoConsultorio: '',
    persona_id: 0,
    especialidad_id: 0
  }

  constructor(private medicoServicio: MedicoService, private personaServicio: ServicioPersonaService, private especialidadServicio: EspecialidadesService, private router: Router) { }

  ngOnInit(){
    this.obtenerPersonasMedicos();
    this.obtenerEspecialidades();
  }

  obtenerEspecialidades() {
    this.especialidadServicio.obtenerEspecialidades().subscribe(
      (res: any[]) => {
        this.especialidades = res;
        console.log(res);
      },
      (error: any) => {
        console.error('Error al obtener las especialidades', error);
      }
    );
  }


  obtenerPersonasMedicos() {
    this.personaServicio.obtenerPersonasMedicos().subscribe(
      (res: any[]) => {
        // Filtrar solo las personas que son médicos (esMedico === true)
        this.personasMedicos = res.filter(persona => persona.esMedico);
        console.log(this.personasMedicos);
      },
      (error: any) => {
        console.error('Error al obtener la lista de médicos', error);
      }
    );
  }

  form_register() {
    // Llamar al servicio registrarMedico para guardar el médico con su especialidad
    this.medicoServicio.registrarMedico(this.medico.persona_id, this.medico.especialidad_id, this.medico.telenoConsultorio).subscribe(
      (response: any) => {
        // Manejar la respuesta del backend si es necesario
        console.log('Médico registrado correctamente', response);
      },
      (error: any) => {
        // Manejar el error si ocurre
        console.error('Error al registrar médico', error);
      }
    );
  }

  






}
