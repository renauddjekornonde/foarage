package sn.forage.gestionForage.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Date dateFacturation;

    @Column
    private Date dateLimite;
    @OneToMany(mappedBy = "facture")
    private List<Consommation> consommations;
}
