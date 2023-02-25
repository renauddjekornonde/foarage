package sn.forage.gestionForage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.forage.gestionForage.model.Compteur;

public interface CompteurRepository extends JpaRepository<Compteur, Long> {
}
