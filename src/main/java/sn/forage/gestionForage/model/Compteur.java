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
public class Compteur {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int num_compteur;
    @Column
    private int id_consommation;
}
