package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
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

    @Column(nullable = false,length = 50)
    private String nombreAsesor;

    @Column(nullable = false,length = 50)
    private String nombreEstudiante1;
    
    private String rutaCartaAceptacion;

    
}
