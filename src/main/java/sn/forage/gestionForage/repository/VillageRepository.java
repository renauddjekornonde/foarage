package sn.forage.gestionForage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.forage.gestionForage.model.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village,Long>{
}
