package sn.forage.gestionForage.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Date date;
    @Column
    private int numero;
    @Column
    private String description;

}
