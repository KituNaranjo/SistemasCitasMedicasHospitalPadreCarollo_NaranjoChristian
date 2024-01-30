import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicioPersonaService {
  constructor(private httpClient: HttpClient){}
  public crearPersona(persona: any){
    return this.httpClient.post("http://localhost:8080/personas/registrar",persona);
  }
  public obtenerPersonasMedicos(){
    let url = "http://localhost:8080/personas/obtenerPersonas";
    return this.httpClient.get<any>(url);     
  }
  obtenerPersonasPacientes() {
    let url = 'http://localhost:8080/personas/obtenerPersonas'; 
    return this.httpClient.get<any>(url);
  }
}
