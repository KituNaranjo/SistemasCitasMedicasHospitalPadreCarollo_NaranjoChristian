package com.sistemacitasmedicas.sistemacitasmedicas.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Usuario;

@Entity
@Table(name="personas")
public class Persona implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer persona_id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private String fechaNacimiento;
    private String estado;
    private String sexo;
    private String tipo;
    private boolean getCliente=false;
    private boolean getMedico=false;
    private boolean getEmpleado=false;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "persona")
    private Set<Usuario> usuarios = new HashSet<>();
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    List<CabeceraFactura> cabeceraFacturas = new ArrayList<>();
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Medico> medicoEspecialidades = new ArrayList<>();
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Cita> medicoCita = new ArrayList<>();
    public Persona(){
    }
    public Persona(Integer persona_id, String cedula, String nombre, String apellido, String direccion, String telefono,
                   String correo, String estado, String fechaNacimiento, String sexo, String tipo) {
        this.persona_id = persona_id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.tipo = tipo;
    }
    public Persona(String cedula, String nombre, String apellido, String direccion, String telefono,
                   String correo, String estado, String fechaNacimiento, String sexo, String tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.tipo = tipo;
    }
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public List<CabeceraFactura> getCabeceraFacturas() {
        return cabeceraFacturas;
    }
    public void setCabeceraFacturas(List<CabeceraFactura> cabeceraFacturas) {
        this.cabeceraFacturas = cabeceraFacturas;
    }
    public List<Medico> getMedicoEspecialidades() {
        return medicoEspecialidades;
    }
    public void setMedicoEspecialidades(List<Medico> medicoEspecialidades) {
        this.medicoEspecialidades = medicoEspecialidades;
    }
    public List<Cita> getMedicoCita() {
        return medicoCita;
    }
    public void setMedicoCita(List<Cita> medicoCita) {
        this.medicoCita = medicoCita;
    }
    public Integer getPersona_id() {
        return persona_id;
    }
    public void setPersona_id(Integer persona_id) {
        this.persona_id = persona_id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean getCliente() {
        return getCliente;
    }
    public void setCliente(boolean getCliente) {
        this.getCliente = getCliente;
    }
    public boolean getMedico() {
        return getMedico;
    }
    public void setMedico(boolean getMedico) {
        this.getMedico = getMedico;
    }
    public boolean getEmpleado() {
        return getEmpleado;
    }
    public void setEmpleado(boolean getEmpleado) {
        this.getEmpleado = getEmpleado;
    }
    public void asignarRolesPorTipo() {
        switch (tipo) {
            case "Cliente":
                getCliente = true;
                getMedico = false;
                getEmpleado = false;
                break;
            case "Medico":
                getCliente = false;
                getMedico = true;
                getEmpleado = false;
                break;
            case "Empleado":
                getCliente = false;
                getMedico = false;
                getEmpleado = true;
                break;
            default:
                getCliente = false;
                getMedico = false;
                getEmpleado = false;
                break;
        }
    }
}
