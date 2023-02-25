package sn.forage.gestionForage.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;
    @Column
    private String nom_chef_village;

    @OneToMany(mappedBy = "village")
    private List<Clients> client;


}
