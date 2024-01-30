import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {
  constructor(private httpClient: HttpClient){}
  public obtenerFacturas(){
    let url = "http://localhost:8080/facturaControlador/obtenerFacturas";
    return this.httpClient.get<any>(url);     
  }
  public crearFacturas(personaId: number, servicioId: number, cantidad: number) {
    console.log('          '+personaId)
    const factura = {
      personaId: personaId,
      servicioId: servicioId,
      cantidad:cantidad
    };
    console.log('http://localhost:8080/facturaControlador/crear')
    const url = `http://localhost:8080/facturaControlador/crear/${personaId}/${servicioId}/${cantidad}`;
    return this.httpClient.post(url,factura);
  }
}
