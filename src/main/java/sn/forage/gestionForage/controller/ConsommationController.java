package sn.forage.gestionForage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forage.gestionForage.model.Compteur;
import sn.forage.gestionForage.model.Consommation;
import sn.forage.gestionForage.repository.CompteurRepository;
import sn.forage.gestionForage.repository.ConsommationRepository;

import java.util.List;
import java.util.Optional;

public class ConsommationController {
    @Autowired
    private ConsommationRepository consommationRepository;

    @GetMapping("/consommation")
    public List<Consommation> getAllConsommation(){
        return consommationRepository.findAll();
    }

    @PostMapping("/createconsommation")
    public Consommation createConsommation(@RequestBody Consommation consommation) {
        return consommationRepository.save(consommation);
    }

    @GetMapping("/consommation/{id}")
    public Optional<Consommation> getConsommationById(@PathVariable(value = "id") Long consommationId) {
        return consommationRepository.findById(consommationId);
    }

    @PutMapping("/consommations/{id}")
    public Consommation updateConsommation(@PathVariable(value = "id") Long consommationId,
                                   @RequestBody Consommation consommationDetails) {
        Consommation consommation = consommationRepository.findById(consommationId)
                .orElseThrow();

        consommation.setNombreLitre(consommationDetails.getNombreLitre());
        consommation.setPrixLitre(consommationDetails.getPrixLitre());
        consommation.setDate(consommationDetails.getDate());
        consommation.setCompteur(consommationDetails.getCompteur());
        consommation.setFacture(consommationDetails.getFacture());

        Consommation updateConsommation = consommationRepository.save(consommation);
        return updateConsommation;
    }

    @DeleteMapping("/delConsommation/{id}")
    public ResponseEntity<?> deleteConsommation(@PathVariable(value = "id") Long consommationId) {
        Consommation consommation = consommationRepository.findById(consommationId)
                .orElseThrow();

        consommationRepository.delete(consommation);

        return ResponseEntity.ok().build();
    }
}
