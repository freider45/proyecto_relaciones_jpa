package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "FormatosA")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class FormatoA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormatoA;
    @Column(unique = true ,name = "titulo", nullable = false, length = 100)
    private String titulo;
    @Column(name = "objetivo_general", nullable = false, columnDefinition = "TEXT")
    private String objetivoGeneral;
    @Column(name = "objetivos_especificos", nullable = false, columnDefinition = "TEXT")
    private String objetivosEspecificos;

    // Un formato tiene un estado
    @OneToOne(mappedBy = "objFormatoA", cascade = CascadeType.PERSIST)
    private Estado objEstado;

    //Muchos formatos A pertencen a un docente
    @ManyToOne
    @JoinColumn(name = "idFkDocente", nullable = false)
    private Docente objDocente;

    //Un formato A puede tener muchas evaluaciones (maximo 3)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objFormatoA")
    private List<Evaluacion> evaluaciones;

    public FormatoA(String titulo, String objetivoGeneral, String objetivosEspecificos) {
        this.titulo = titulo;
        this.objetivoGeneral = objetivoGeneral;
        this.objetivosEspecificos = objetivosEspecificos;
    }
    
}
