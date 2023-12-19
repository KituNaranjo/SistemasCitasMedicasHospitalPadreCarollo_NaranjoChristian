package com.sistemacitasmedicas.sistemacitasmedicas.implementacion;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Hospital;
import com.sistemacitasmedicas.sistemacitasmedicas.repositorio.HospitalRepositorio;
import com.sistemacitasmedicas.sistemacitasmedicas.servicios.HospitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class HospitalServicioImplementacion implements HospitalServicio {
    @Autowired
    HospitalRepositorio hospitalRepositorio;
    @Override
    public Hospital guardarprescripcion(Hospital hospital, List<Hospital> hospitalPersona) {
        return hospitalRepositorio.save(hospital);
    }
    @Override
    public List<Hospital> listarHospital() {
        return hospitalRepositorio.findAll();
    }
    @Override
    public Hospital obtenerHospitalPorId(Integer hospital_id) {
        Optional<Hospital> hospitalOptional = hospitalRepositorio.findById(hospital_id);
        return hospitalOptional.orElse(null);
    }
    @Override
    public Optional<Hospital> get(Integer hospital_id) {
        return hospitalRepositorio.findById(hospital_id);
    }
    @Override
    public void delete(Integer id) {
        hospitalRepositorio.deleteById(id);
    }
    public Hospital actualizarHospital(Integer id, Hospital hospitalActualizada) {
        Optional<Hospital> hospitalOptional = hospitalRepositorio.findById(id);
        if (hospitalOptional.isPresent()) {
            Hospital hospitalExistente = hospitalOptional.get();
            hospitalExistente.setCertificados(hospitalActualizada.getCertificados());
            hospitalExistente.setOrdenes(hospitalActualizada.getOrdenes());
            hospitalExistente.setPrescripciones(hospitalActualizada.getPrescripciones());
            return hospitalRepositorio.save(hospitalExistente);
        } else {
            return null;
        }
    }
}