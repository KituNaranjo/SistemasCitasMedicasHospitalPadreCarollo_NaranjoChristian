package com.sistemacitasmedicas.sistemacitasmedicas.servicios;

import com.sistemacitasmedicas.sistemacitasmedicas.modelo.Hospital;
import java.util.List;
import java.util.Optional;

public interface HospitalServicio {
    List<Hospital> listarHospital();
    Optional<Hospital> get(Integer id);
    Hospital guardarprescripcion(Hospital hospital, List<Hospital> hospitalPersona) throws Exception;
    Hospital obtenerHospitalPorId(Integer hospital_id);
    void delete(Integer id);
    Hospital actualizarHospital(Integer id, Hospital hospitalActualizada);
}
