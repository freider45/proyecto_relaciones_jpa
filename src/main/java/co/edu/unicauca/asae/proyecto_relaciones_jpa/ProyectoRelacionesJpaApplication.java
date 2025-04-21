package co.edu.unicauca.asae.proyecto_relaciones_jpa;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Docente;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Estado;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Evaluacion;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.FormatoA;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.FormatoPPA;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.FormatoTIA;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Historico;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Observacion;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.models.Rol;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories.DocentesRepository;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories.EstadosRepository;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories.EvaluacionesRepository;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories.FormatosPPARepository;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories.FormatosTIARepository;
import co.edu.unicauca.asae.proyecto_relaciones_jpa.repositories.ObservacionesRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class ProyectoRelacionesJpaApplication implements CommandLineRunner {

	@Autowired
	private DocentesRepository servicioBDDocentes;

	@Autowired
	private FormatosPPARepository servicioBDFormatosPPA;

    @Autowired
    private FormatosTIARepository servicioBDFormatosTIA;

    @Autowired
    private EvaluacionesRepository servicioBDEvaluaciones;

    @Autowired
    private ObservacionesRepository servicioBDObservaciones;

	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoRelacionesJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//crearFormatoA(1, 1);
        //crearFormatoA(0, 2);
        //pruebaCrearObservacion();
        //listarObservaciones(2, 0);
        //listarMiembrosComite();
        //consultarFormatosAPorDocente(2);
 	}

	@Transactional
    public void crearFormatoA(int tipoFormato, int idDocente) {
        Optional<Docente> docenteOptional = servicioBDDocentes.findById(idDocente);

        if (docenteOptional.isEmpty()) {
            throw new RuntimeException("El docente con ID " + idDocente + " no existe.");
        }

        Docente docente = docenteOptional.get();
        Estado estado = new Estado();

        estado.setEstadoActual("En formulación");
        estado.setFechaRegistroEstado(new Date()); 

        if (tipoFormato == 0) {
            FormatoTIA formatotia = new FormatoTIA(
                "Desarrollo metodo para mejora de procesos agiles en scrum",
                "Desarollar el metodo",
                "Probar si el metodo funciona",
                "Johan benavides"
            );
            formatotia.setObjDocente(docente);
            estado.setObjFormatoA(formatotia);
            formatotia.setObjEstado(estado);
            servicioBDFormatosTIA.save(formatotia);
        } else {
            FormatoPPA formatoppa = new FormatoPPA(
                "Desarrollo modelo inteligencia artificial con redes generativas",
                "Desarollar el modelo de IA",
                "Probar si el modelo funciona",
                "Libardo pantoja",
                "Ronald Manquillo",
                "ruta/carta.pdf"
            );
            formatoppa.setObjDocente(docente);
            estado.setObjFormatoA(formatoppa);
            formatoppa.setObjEstado(estado);
            servicioBDFormatosPPA.save(formatoppa);
        }
    }

    @Transactional
    public void crearObservacion(String textoObservacion, int idFormatoA, List<Integer> idsDocentes, int tipoFormato) {
        FormatoA formato = obtenerFormatoPorTipoEId(idFormatoA, tipoFormato);

        Evaluacion evaluacion;
        List<Evaluacion> evaluaciones = servicioBDEvaluaciones.findByObjFormatoAOrderByIdEvaluacionDesc(formato);

        Evaluacion ultimaEvaluacion = evaluaciones.isEmpty() ? null : evaluaciones.get(0);
       

        if (ultimaEvaluacion != null && "Por corregir".equalsIgnoreCase(ultimaEvaluacion.getConcepto())) {
            ultimaEvaluacion.setConcepto("Por corregir");
            evaluacion = ultimaEvaluacion;
        } else {
            evaluacion = new Evaluacion();
            evaluacion.setConcepto("Aún por establecer");
            evaluacion.setNombreCoordinador("Julio Ariel");
            evaluacion.setFechaRegistroConcepto(new Date());
            evaluacion.setObjFormatoA(formato);
            servicioBDEvaluaciones.save(evaluacion);
        }
        Observacion observacion = new Observacion();
        observacion.setObservacion(textoObservacion);
        observacion.setFechaRegistroObservacion(new Date());
        observacion.setObjEvaluacion(evaluacion);
        servicioBDObservaciones.save(observacion);

        for (Integer idDocente : idsDocentes) {
            Docente docente = servicioBDDocentes.getReferenceById(idDocente);

            if (docente.getObservaciones() == null) {
                docente.setObservaciones(new ArrayList<>());
            }

            docente.getObservaciones().add(observacion);
            servicioBDDocentes.save(docente);
        }
    }

    private void pruebaCrearObservacion() {
        String texto = "El trabajo presenta avances, pero requiere correcciones en la metodología.";
        int idFormatoA = 2;
        List<Integer> idsDocentes = Arrays.asList(3);
        int tipoFormato = 1;

        crearObservacion(texto, idFormatoA, idsDocentes, tipoFormato);
    }

    @Transactional
    public void listarObservaciones(int idFormatoA, int tipoFormatoA){
        FormatoA formato = obtenerFormatoPorTipoEId(idFormatoA, tipoFormatoA);
        System.out.println();
        System.out.println();
        System.out.println("Formato A ID: " + formato.getIdFormatoA());
        System.out.println("\nTitulo: "+formato.getTitulo());
        System.out.println("Objetivo general: "+formato.getObjetivoGeneral());
        System.out.println("Objetivos especificos: "+ formato.getObjetivosEspecificos());
        System.out.println("Estado del formato: " + formato.getObjEstado().getEstadoActual()); 
        System.out.println("------");
        List<Evaluacion> evaluaciones = formato.getEvaluaciones();
        if (evaluaciones.isEmpty()) {
            System.out.println("Este formato aún no tiene evaluaciones.");
            return;
        }
        evaluaciones.sort((e1, e2) -> Integer.compare(e2.getIdEvaluacion(), e1.getIdEvaluacion()));
        Evaluacion evaluacion = evaluaciones.get(0);
        System.out.println("Evaluacion: ");
        System.out.println("Concepto: " + evaluacion.getConcepto());
        System.out.println("Coordinador: " + evaluacion.getNombreCoordinador());
        System.out.println("Fecha de registro: " + evaluacion.getFechaRegistroConcepto());
        System.out.println("Observaciones:");

        List<Observacion> observaciones = evaluacion.getObservaciones();
        if (observaciones.isEmpty()) {
            System.out.println(" - No hay observaciones registradas.");
        } else {
            for (Observacion obs : observaciones) {
                System.out.println("   Observacion: " + obs.getObservacion());
                System.out.println("Docente(s) que la realizaron:");

                List<Docente> docentes = obs.getDocentes();
                for (Docente doc : docentes) {
                    System.out.println(doc.getNombresDocente() + " " + doc.getApellidosDocente());
                }
                System.out.println("------");
            }
        }
        System.out.println("=============================");
        System.out.println();
    }

    private FormatoA obtenerFormatoPorTipoEId(int idFormatoA, int tipoFormato) {
        if (tipoFormato == 0) {
            return servicioBDFormatosTIA.getReferenceById(idFormatoA);
        } else {
            return servicioBDFormatosPPA.getReferenceById(idFormatoA);
        }
    }

    @Transactional
    public void listarMiembrosComite() {
        List<Docente> docentes = servicioBDDocentes.findAll();
        System.out.println("\nLISTADO DE MIEMBROS DEL COMITÉ");

        for (Docente docente : docentes) {
            List<Historico> historicos = docente.getHistoricos();

            if (historicos != null && !historicos.isEmpty()) {
                for (Historico historico : historicos) {
                    Rol rol = historico.getObjRol();
                    
                    if ("Miembro del comite".equalsIgnoreCase(rol.getRoleAsignado())) {
                        System.out.println("\nDocente: " + docente.getNombresDocente() + " " + docente.getApellidosDocente());
                        System.out.println(" - Rol: " + rol.getRoleAsignado());
                        System.out.println("   Fecha inicio: " + historico.getFechaInicio());
                        System.out.println("   Fecha fin: " + historico.getFechaFin());
                        System.out.println("--------------------------");
                    }
                }
            }
        }
    }  

    @Transactional
    public void consultarFormatosAPorDocente(int idDocente) {
        Optional<Docente> docenteOpt = servicioBDDocentes.findById(idDocente);

        if (docenteOpt.isEmpty()) {
            System.out.println("Docente no encontrado.");
            return;
        }

        Docente docente = docenteOpt.get();
        System.out.println("\nDocente: " + docente.getNombresDocente() + " " + docente.getApellidosDocente());

        List<FormatoA> formatos = docente.getFormatosA();
        if (formatos.isEmpty()) {
            System.out.println("Este docente no tiene formatos A registrados.");
            return;
        }

        for (FormatoA formato : formatos) {
            System.out.println("\nFormato ID: " + formato.getIdFormatoA());
            System.out.println("Título: " + formato.getTitulo());
            System.out.println("Objetivo general: \n" + formato.getObjetivoGeneral());
            
            List<Evaluacion> evaluaciones = formato.getEvaluaciones();
            for (Evaluacion evaluacion : evaluaciones) {
                System.out.println("  Evaluación:");
                System.out.println("    Concepto: " + evaluacion.getConcepto());
                System.out.println("    Fecha: " + evaluacion.getFechaRegistroConcepto());

                List<Observacion> observaciones = evaluacion.getObservaciones();
                if (observaciones.isEmpty()) {
                    System.out.println("    No hay observaciones.");
                } else {
                    for (Observacion obs : observaciones) {
                        System.out.println("    Observación: \n" + obs.getObservacion());
                        System.out.println("=======================================");
                    }
                }
            }
        }
    }

    

    




}
