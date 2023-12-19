package com.sistemacitasmedicas.sistemacitasmedicas.modelo;

import javax.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospital_id;
    private String prescripciones;
    private String ordenes;
    private String certificados;
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona persona;
    @ManyToOne
    private Medico medico;
    public Hospital(){
    }
    public Hospital(Integer hospital_id, String prescripciones, String ordenes, String certificados) {
        this.hospital_id = hospital_id;
        this.prescripciones = prescripciones;
        this.ordenes = ordenes;
        this.certificados = certificados;
    }
    public Integer getHospital_id() {
        return hospital_id;
    }
    public void setHospital_id(Integer hospital_id) {
        this.hospital_id = hospital_id;
    }
    public String getPrescripciones() {
        return prescripciones;
    }
    public void setPrescripciones(String prescripciones) {
        this.prescripciones = prescripciones;
    }
    public String getOrdenes() {
        return ordenes;
    }
    public void setOrdenes(String ordenes) {
        this.ordenes = ordenes;
    }
    public String getCertificados() {
        return certificados;
    }
    public void setCertificados(String certificados) {
        this.certificados = certificados;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
