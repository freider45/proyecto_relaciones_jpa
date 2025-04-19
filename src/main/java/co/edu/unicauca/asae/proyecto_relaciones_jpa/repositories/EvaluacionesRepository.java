package co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Evaluacion;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.FormatoA;

public interface EvaluacionesRepository extends JpaRepository<Evaluacion, Integer> {
    List<Evaluacion> findByObjFormatoAOrderByIdEvaluacionDesc(FormatoA formatoA);
}
