package sn.forage.gestionForage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.forage.gestionForage.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
