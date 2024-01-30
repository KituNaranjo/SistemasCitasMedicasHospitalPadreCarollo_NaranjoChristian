import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CitaService {
  constructor(private httpClient: HttpClient){}
  public registrarCita(medicoId: number, personaId: number, fechaCita: string, hora: string) {
    const url = `http://localhost:8080/cita/crear/${medicoId}/${personaId}`;
    const citaData = {
      fechaCita: fechaCita,
      hora: hora,
      estado: false, 
    };
    return this.httpClient.post(url, citaData);
  }
}
