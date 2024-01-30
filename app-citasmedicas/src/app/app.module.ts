import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { AboutComponent } from './components/about/about.component';
import { ServiciosComponent } from './components/servicios/servicios.component';
import { CrearServicioComponent } from './components/crear-servicio/crear-servicio.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CitaComponent } from './components/cita/cita.component';
import { MedicoComponent } from './components/medico/medico.component';

import { ClinicaComponent } from './components/clinica/clinica.component';

import { FacturaComponent } from './components/factura/factura.component';
import { EspecialidadesComponent } from './components/especialidades/especialidades.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    NavbarComponent,
    LoginComponent,
    MainComponent,
    AboutComponent,
    ServiciosComponent,
    CrearServicioComponent,
    CitaComponent,
    MedicoComponent,
    ClinicaComponent,
    EspecialidadesComponent,
    FacturaComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
