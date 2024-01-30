import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {
  constructor(private httpClient: HttpClient){}
  public registrarMedico(personaId: number, especialidadId: number, telefonoConsultorio: string) {
    const url = `http://localhost:8080/medicoControlador/guardarMedicoEspecialidad/${personaId}/${especialidadId}`;
    const medicoData = {
      telefonoConsultorio: telefonoConsultorio
    };
    return this.httpClient.post(url, medicoData);
  }
  public obtenerMedicos() {
    let url = 'http://localhost:8080/medicoControlador/obtenerMedicos'; 
    return this.httpClient.get<any>(url);
  }
  public obtenerMedicoPorId(personaId: number) {
    let url = `http://localhost:8080/medicoControlador/obtenerMedicoIdPorPersonaId/${personaId}`; 
    return this.httpClient.get<any>(url);
  }
}
