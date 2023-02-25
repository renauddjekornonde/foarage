package sn.forage.gestionForage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forage.gestionForage.model.Abonnement;
import sn.forage.gestionForage.repository.AbonnementRepository;

import java.util.List;
import java.util.Optional;

public class AbonnementController {
    @Autowired
    private AbonnementRepository abonnementRepository;

    @GetMapping("/abonnement")
    public List<Abonnement> getAllAbonnements(){
        return abonnementRepository.findAll();
    }

    @PostMapping("/createAbon")
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @GetMapping("/abonnement/{id}")
    public Optional<Abonnement> getAbonnementById(@PathVariable(value = "id") Long abonnementId) {
        return abonnementRepository.findById(abonnementId);
    }

    @PutMapping("/abonnements/{id}")
    public Abonnement updateUser(@PathVariable(value = "id") Long abonnementId,
                           @RequestBody Abonnement abonnementDetails) {
        Abonnement abonnement = abonnementRepository.findById(abonnementId)
                .orElseThrow();

        abonnement.setDate(abonnementDetails.getDate());
        abonnement.setNumero(abonnementDetails.getNumero());
        abonnement.setDescription(abonnementDetails.getDescription());

        Abonnement updatedAbonnement = abonnementRepository.save(abonnement);
        return updatedAbonnement;
    }

    @DeleteMapping("/delAbonnement/{id}")
    public ResponseEntity<?> deleteAbonnement(@PathVariable(value = "id") Long abonnementId) {
        Abonnement abonnement = abonnementRepository.findById(abonnementId)
                .orElseThrow();

        abonnementRepository.delete(abonnement);

        return ResponseEntity.ok().build();
    }
}