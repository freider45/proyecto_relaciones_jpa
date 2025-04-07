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
@PrimaryKeyJoinColumn(name = "idFormatoA")
public class FormatoTIA extends FormatoA {
    
    @Column(nullable = false,length = 50)
    private String nombreEstudiante1;

    @Column(length = 50)
    private String nombreEstudiante2;
    
}
