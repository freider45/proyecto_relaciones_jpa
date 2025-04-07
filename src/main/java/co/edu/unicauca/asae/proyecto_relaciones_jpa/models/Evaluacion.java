package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.sql.Date;
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

    @Column(unique = true, nullable = false)
    private int idObservacion;

    private String observacion;

    @Column(nullable = false)
    private Date fechaRegistro;

    //Muchas evaluaciones pertenecen a un formato A
    @ManyToOne
    @JoinColumn(name = "idFkFormatoA", nullable = false)
    private FormatoA objFormatoA;

    //Una evaluación tiene muchas observaciones
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objEvaluacion")
    private List<Observacion> observaciones;

}
