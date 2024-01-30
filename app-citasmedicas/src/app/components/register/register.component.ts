import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { ServicioPersonaService } from 'src/app/services/servicio-persona.service';
import { UsuarioService } from 'src/app/services/usuario.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  modalSwith:boolean | undefined;

  public persona = {
  
    cedula:'',
    nombre:'',
    apellido:'',
    direccion:'',
    telefono:'',
    correo:'',
    estado: 'activo',
    fechaNacimiento:'',
    sexo:'',
    tipo:'',
  
  }

  public usuario = {

    encargo: '',
    username: '',
    password: '',
    persona:{
      persona_id: '3'
    }

  }

  constructor(private personaServicio: ServicioPersonaService, private usuarioServicio: UsuarioService, private router: Router) { }

  ngOnInit(){}

  openModal(){
    this.modalSwith = true;
  }

  // form_register(){

  //   this.personaServicio.crearPersona(this.persona).subscribe(
  //       (personaData) => {
  //         console.log(personaData);  

  //         const personaId = personaData.persona_id; // Obtén el ID de la persona desde la respuesta del servidor
  //         this.usuario.persona.persona_id = personaId; // Asigna el ID de la persona al objeto usuario
  

  //         this.usuarioServicio.crearUsuario(this.usuario).subscribe(
  //           (usuarioData) => {
  //             console.log(usuarioData);  
  //           }
  //         )
  //       },(error) => {  
  //         console.log(error);
  //       })

  // }

  form_register() {
    this.personaServicio.crearPersona(this.persona).subscribe(
      (response: any) => {
        const personaGuardada = response.persona;
        const personaId = response.persona_id;

        console.log(personaGuardada);
        console.log(personaId);

        this.usuario.persona.persona_id = personaId;

        this.usuarioServicio.crearUsuario(this.usuario).subscribe(
          (usuarioData) => {
            console.log(usuarioData);
          }
        );
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

