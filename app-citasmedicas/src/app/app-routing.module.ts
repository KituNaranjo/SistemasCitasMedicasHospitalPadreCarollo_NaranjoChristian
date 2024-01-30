import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { CrearServicioComponent } from './components/crear-servicio/crear-servicio.component';
import { FacturaComponent } from './components/factura/factura.component';
import { EspecialidadesComponent } from './components/especialidades/especialidades.component';
import { ClinicaComponent } from './components/clinica/clinica.component';
import { MedicoComponent } from './components/medico/medico.component';
import { CitaComponent } from './components/cita/cita.component';
import { AboutComponent } from './components/about/about.component';

const routes: Routes = [
  {path: "", redirectTo:"main", pathMatch:"full"},
  {path: "main", component:  MainComponent},
  {path: "crearCita", component:  CitaComponent},
  {path: "agregarMedico", component:  MedicoComponent},
  {path: "registrarse", component:  RegisterComponent},
  {path: "login", component:  LoginComponent},
  {path: "crearServicio", component:  CrearServicioComponent},
  {path: "factura", component: FacturaComponent},
  {path: "especialidad", component: EspecialidadesComponent},
  {path: "clinica", component: ClinicaComponent},
  {path: "medico", component: MedicoComponent},
  {path: "sobremi", component: AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
