package sn.forage.gestionForage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forage.gestionForage.model.Facture;
import sn.forage.gestionForage.model.Village;
import sn.forage.gestionForage.repository.FactureRepository;
import sn.forage.gestionForage.repository.VillageRepository;

import java.util.List;
import java.util.Optional;

public class VillageController {
    @Autowired
    private VillageRepository villageRepository;

    @GetMapping("/village")
    public List<Village> getAllVillage(){
        return villageRepository.findAll();
    }

    @PostMapping("/createvillage")
    public Village createVillage(@RequestBody Village village) {
        return villageRepository.save(village);
    }

    @GetMapping("/village/{id}")
    public Optional<Village> getVillageById(@PathVariable(value = "id") Long villageId) {
        return villageRepository.findById(villageId);
    }

    @PutMapping("/villages/{id}")
    public Village updateVillage(@PathVariable(value = "id") Long villageId,
                                 @RequestBody Village villageDetails) {
        Village village = villageRepository.findById(villageId)
                .orElseThrow();

        village.setNom(villageDetails.getNom());
        village.setNom_chef_village(villageDetails.getNom_chef_village());
        village.setClient(villageDetails.getClient());

        Village updateVillage = villageRepository.save(village);
        return updateVillage;
    }

    @DeleteMapping("/delVillage/{id}")
    public ResponseEntity<?> deleteVillage(@PathVariable(value = "id") Long villageId) {
        Village village = villageRepository.findById(villageId)
                .orElseThrow();

        villageRepository.delete(village);

        return ResponseEntity.ok().build();
    }
}
