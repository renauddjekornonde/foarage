package sn.forage.gestionForage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forage.gestionForage.model.Consommation;
import sn.forage.gestionForage.model.Facture;
import sn.forage.gestionForage.repository.ConsommationRepository;
import sn.forage.gestionForage.repository.FactureRepository;

import java.util.List;
import java.util.Optional;

public class FactureController {
    @Autowired
    private FactureRepository factureRepository;

    @GetMapping("/facture")
    public List<Facture> getAllFacture(){
        return factureRepository.findAll();
    }

    @PostMapping("/createfacture")
    public Facture createFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @GetMapping("/facture/{id}")
    public Optional<Facture> getFactureById(@PathVariable(value = "id") Long factureId) {
        return factureRepository.findById(factureId);
    }

    @PutMapping("/factures/{id}")
    public Facture updateFacture(@PathVariable(value = "id") Long factureId,
                                           @RequestBody Facture factureDetails) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow();

        facture.setDateFacturation(factureDetails.getDateFacturation());
        facture.setDateLimite(factureDetails.getDateLimite());

        Facture updateFacture = factureRepository.save(facture);
        return updateFacture;
    }

    @DeleteMapping("/delFacture/{id}")
    public ResponseEntity<?> deleteFacture(@PathVariable(value = "id") Long factureId) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow();

        factureRepository.delete(facture);

        return ResponseEntity.ok().build();
    }
}
