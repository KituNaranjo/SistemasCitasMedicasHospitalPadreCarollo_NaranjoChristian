import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  constructor(private httpClient: HttpClient){}
  public crearUsuario(usuario: any){
    return this.httpClient.post("http://localhost:8080/usuarios/registrar",usuario);
  }
}
