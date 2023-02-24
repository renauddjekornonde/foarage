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

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table
public class Abonnement {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private Date date;
    @Column
    private int numero;
    @Column
    private String description;

}
