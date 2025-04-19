package co.edu.unicauca.asae.proyecto_relaciones_jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "role_asignado", nullable = false, length = 100)
    private String roleAsignado;

    //Un rol tiene muchos historicos
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objRol")
    private List<Historico> historicos;
    
}
