package co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Estado;

public interface EstadosRepository extends CrudRepository<Estado, Integer> {
    
}
