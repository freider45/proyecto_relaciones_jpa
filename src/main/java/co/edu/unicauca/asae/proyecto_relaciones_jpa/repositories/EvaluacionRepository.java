package co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Evaluacion;

public interface EvaluacionRepository extends CrudRepository<Evaluacion, Integer> {
    
}
