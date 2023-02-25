package sn.forage.gestionForage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.forage.gestionForage.model.Clients;
import sn.forage.gestionForage.model.Compteur;
import sn.forage.gestionForage.model.Consommation;
import sn.forage.gestionForage.model.Facture;

import java.util.List;

public interface ConsommationRepository extends JpaRepository<Consommation, Long> {
    List<Consommation> findByCompteur(Compteur compteur);
    List<Consommation> findByFacture(Facture facture);
}
