package sn.forage.gestionForage.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nomFamille;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_village")
    private Village village;
    @Column
    private int numTel;

}
