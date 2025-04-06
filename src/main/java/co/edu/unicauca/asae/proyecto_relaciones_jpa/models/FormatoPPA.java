package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class FormatoPPA extends FormatoA{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormatoPPA;
    private String nombreAsesor;
    private String nombreEstudiante1;
    private String rutaCartaAceptacion;

    
}
