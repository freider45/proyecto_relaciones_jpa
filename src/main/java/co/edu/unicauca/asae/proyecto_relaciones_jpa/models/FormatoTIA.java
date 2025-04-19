package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FormatosTIA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "idFormatoTIA")
public class FormatoTIA extends FormatoA {

    @Column(name = "nombre_estudiante1", nullable = false, length = 100)
    private String nombreEstudiante1;
    @Column(name = "nombre_estudiante2", nullable = true, length = 100)
    private String nombreEstudiante2;
    
    public FormatoTIA(String titulo, String objetivoGeneral, String objetivosEspecificos,
     String nombreEstudiante1, String nombreEstudiante2)
    {
        super(titulo, objetivoGeneral, objetivosEspecificos);
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }

    public FormatoTIA(String titulo, String objetivoGeneral, String objetivosEspecificos,
     String nombreEstudiante1)
    {
        super(titulo, objetivoGeneral, objetivosEspecificos);
        this.nombreEstudiante1 = nombreEstudiante1;
    }
}
