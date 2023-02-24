package sn.forage.gestionForage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Village {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nom;
    @Column
    private String nom_chef_village;


}
