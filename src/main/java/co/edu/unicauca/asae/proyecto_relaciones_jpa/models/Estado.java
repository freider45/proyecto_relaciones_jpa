package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Estados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;
    private String estadoActual;
    private Date fecha;
    
    @OneToOne
    @JoinColumn(name = "idFkFormatoA")
    private FormatoA formatoA;

}
