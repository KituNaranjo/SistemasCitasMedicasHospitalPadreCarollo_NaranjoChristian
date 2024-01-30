import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiciosService {
  constructor(private httpClient: HttpClient){}
  public crearServicio(servicio: any){
    return this.httpClient.post("http://localhost:8080/servicio/guardarServicio",servicio);
  }
  public obtenerTodosServicios(){
    let url = "http://localhost:8080/servicio/obtenerTodosServicios";
    return this.httpClient.get<any>(url);     
  }
}
