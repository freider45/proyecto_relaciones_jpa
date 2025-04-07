package co.edu.unicauca.asae.proyecto_relaciones_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Docente;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories.DocenteRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class ProyectoRelacionesJpaApplication implements CommandLineRunner {

	@Autowired
	private DocenteRepository servicioBDDocentes;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoRelacionesJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		almacenarDocente();
	}

	@Transactional
	public void almacenarDocente(){
		Docente docente = new Docente();
		docente.setNombresDocente("Freider");
		docente.setApellidosDocente("Escobar");
		docente.setNombreGrupo("asae");
		docente.setCorreo("freiderescobar@gmail.com");

		this.servicioBDDocentes.save(docente);
	}

}
