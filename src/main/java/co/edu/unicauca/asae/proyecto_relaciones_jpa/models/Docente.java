package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Docentes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocente;
    private String nombresDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;

    //Un docente puede tener muchos formatos A
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<FormatoA> formatosA;

    //Muchos docentes hacen varias observaciones
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "observacion_docente",
        joinColumns = @JoinColumn(name = "idFkDocente"),
        inverseJoinColumns = @JoinColumn(name = "idFkObservacion")
    )
    private List<Observacion> observaciones;

    //Un docente tiene muchos historicos
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<Historico> historicos;

}
