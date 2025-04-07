package co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Historico;

public interface HistoricoRepository extends CrudRepository<Historico, Integer> {
    
}
