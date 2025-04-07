package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FormatosPPA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "idFormatoA")
public class FormatoPPA extends FormatoA{
    private String nombreAsesor;
    private String nombreEstudiante1;
    private String rutaCartaAceptacion;

    
}
