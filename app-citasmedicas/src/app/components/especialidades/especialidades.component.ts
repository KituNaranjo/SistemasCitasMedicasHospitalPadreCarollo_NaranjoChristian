import { Component } from '@angular/core';
import { EspecialidadesService } from 'src/app/services/especialidades.service';

@Component({
  selector: 'app-especialidades',
  templateUrl: './especialidades.component.html',
  styleUrls: ['./especialidades.component.css']
})
export class EspecialidadesComponent {
  especialidades: any[] = [];

  public especialidad = {
    especialidadId: undefined,
    especialidad: ''
  };
  

  constructor(private especialidadesService: EspecialidadesService) { }

  ngOnInit(): void {
    this.obtenerEspecialidades();
  }

  obtenerEspecialidades() {
    this.especialidadesService.obtenerEspecialidades().subscribe(
      (res: any[]) => {
        this.especialidades = res;
        console.log(res); // Agrega esta línea para verificar los datos recibidos
      },
      (error: any) => {
        console.error('Error al obtener especialidades', error);
      }
    );
  }
  

  form_register() {
    this.especialidadesService.crearEspecialidad(this.especialidad).subscribe(
      (data) => {
        console.log(data);
        this.obtenerEspecialidades(); // Actualizar la lista de especialidades después del registro
        this.especialidad.especialidad = ''; // Limpiar el campo de entrada después del registro
      },
      (error) => {
        console.log(error);
      }
    );
  }

  eliminarEspecialidad(especialidadId: number) {
    this.especialidadesService.eliminarEspecialidad(especialidadId).subscribe(
      () => {
        console.log(`Especialidad con ID ${especialidadId} eliminada`);
        this.obtenerEspecialidades(); // Actualizar la lista de especialidades después de eliminar
      },
      (error) => {
        console.error(`Error al eliminar especialidad con ID ${especialidadId}`, error);
      }
    );
  }
  mostrarEspecialidad(especialidad: any) {
    // Mostrar la información de la especialidad en el formulario al hacer clic
    this.especialidad = {
      especialidadId: especialidad.especialidadId,
      especialidad: especialidad.especialidad
    };
  }
  buscarEspecialidadPorId(id: number) {
    this.especialidadesService.obtenerEspecialidadPorId(id).subscribe(
      (res: any) => {
        this.especialidad = res;
        console.log(res); // Muestra la especialidad encontrada en la consola
      },
      (error: any) => {
        console.error('Error al obtener la especialidad por ID', error);
      }
    );
  }
  
}
