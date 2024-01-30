import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServicioLoginService } from 'src/app/services/servicio-login.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  public usuario = {
    username: '',
    password: '',
  }

  constructor(private servicioLogin: ServicioLoginService, private router: Router) { }


  form_login(){
    this.servicioLogin.login(this.usuario).subscribe(
      (data) => {
        console.log(data);  
      },(error) => {  
        console.log(error);
      })


  }

}
