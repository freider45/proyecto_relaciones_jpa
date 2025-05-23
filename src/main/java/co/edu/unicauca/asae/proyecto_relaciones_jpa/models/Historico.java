package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Historicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Historico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true,nullable = false)
    private int idHistorico;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    //Muchos historicos pertenecen a un docente
    @ManyToOne
    @JoinColumn(name = "idFkDocente")
    private Docente objDocente;

    //Muchos historicos pertenecen a un rol
    @ManyToOne
    @JoinColumn(name = "idFkRol")
    private Rol objRol;
}
