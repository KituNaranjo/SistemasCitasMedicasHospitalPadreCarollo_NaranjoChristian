import { Component, OnInit } from '@angular/core';
import { ServiciosService } from 'src/app/services/servicios.service';

@Component({
  selector: 'app-servicios',
  templateUrl: './servicios.component.html',
  styleUrls: ['./servicios.component.css']
})
export class ServiciosComponent  implements OnInit{

  servicios: any[] = [];

  constructor(private serviciosService:ServiciosService) { }

  ngOnInit(): void {
    this.obtenerTodosLibros();
  }

  obtenerTodosLibros(){
    this.serviciosService.obtenerTodosServicios().subscribe((res: any[]) => this.servicios = res, (error: any)=>{
    });
    console.log(this.servicios);
  }

}
