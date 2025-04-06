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
@Table(name = "FormatosTIA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatoTIA extends FormatoA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormatoTIA;
    private String nombreEstudiante1;
    private String nombreEstudiante2;
    
}
