package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Observaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true, nullable = false)
    private int idObservacion;

    @Column(name = "observaciones",length = 150)
    private String observacion;

    @Column(nullable = false)
    private Date fechaRegistroObservacion;

    //Muchas observaciones pertenecen a una evaluación
    @ManyToOne
    @JoinColumn(name = "idFkEvaluacion", nullable = false)
    private Evaluacion objEvaluacion;
    
}
