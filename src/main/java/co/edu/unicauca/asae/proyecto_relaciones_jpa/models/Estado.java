package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.util.Date;

import jakarta.persistence.Column;
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
    @Column(name = "estado_actual", nullable = false, length = 50)
    private String estadoActual;
    @Column(name = "fecha_registro_estado", nullable = false)
    private Date fechaRegistroEstado;
    
    @OneToOne
    @JoinColumn(name = "idFkFormatoA", unique = true)
    private FormatoA objFormatoA;

}
