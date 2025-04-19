package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Evaluaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacion;
    @Column(name = "concepto", nullable = false, length = 255)
    private String concepto;
    @Column(name = "nombre_coordinador", nullable = false, length = 100)
    private String nombreCoordinador;
    @Column(name = "fecha_registro_concepto", nullable = false)
    private Date fechaRegistroConcepto;

    //Muchas evaluaciones pertenecen a un formato A
    @ManyToOne
    @JoinColumn(name = "idFkFormatoA", nullable = false)
    private FormatoA objFormatoA;

    //Una evaluación tiene muchas observaciones
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objEvaluacion")
    private List<Observacion> observaciones;

}
