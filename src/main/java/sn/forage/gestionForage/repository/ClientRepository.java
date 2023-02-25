package sn.forage.gestionForage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.forage.gestionForage.model.Clients;
import sn.forage.gestionForage.model.Village;

import java.util.List;

public interface ClientRepository extends JpaRepository<Clients, Long> {
    List<Clients> findByVillage(Village village);
}
