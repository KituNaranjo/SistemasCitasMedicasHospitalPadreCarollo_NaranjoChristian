import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClinicaService {
  constructor(private httpClient: HttpClient){}
  public registrarClinica(medico_id: number, persona_id: number, prescripciones: string, ordenes: string,certificados:string) {
    console.log('          '+medico_id+persona_id+prescripciones+ordenes+certificados)
    const url = `http://localhost:8080/clinica/crear/${medico_id}/${persona_id}`;
    const ClinicaData = {
       prescripciones: prescripciones,
       ordenes: ordenes,
       certificados: certificados,
    };
    console.log('Error!!! no se registra')
    return this.httpClient.post(url, ClinicaData);
  }
}
