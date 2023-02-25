package sn.forage.gestionForage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forage.gestionForage.model.Clients;
import sn.forage.gestionForage.model.Compteur;
import sn.forage.gestionForage.repository.CompteurRepository;

import java.util.List;
import java.util.Optional;

public class CompteurController {
    @Autowired
    private CompteurRepository compteurRepository;

    @GetMapping("/compteur")
    public List<Compteur> getAllCompteur(){
        return compteurRepository.findAll();
    }

    @PostMapping("/createcompteur")
    public Compteur createCompteur(@RequestBody Compteur compteur) {
        return compteurRepository.save(compteur);
    }

    @GetMapping("/compteur/{id}")
    public Optional<Compteur> getCompteurById(@PathVariable(value = "id") Long compteurId) {
        return compteurRepository.findById(compteurId);
    }

    @PutMapping("/compteurs/{id}")
    public Compteur updateCompteur(@PathVariable(value = "id") Long compteurId,
                                 @RequestBody Compteur compteurDetails) {
        Compteur compteur = compteurRepository.findById(compteurId)
                .orElseThrow();

        compteur.setNum_compteur(compteurDetails.getNum_compteur());
        compteur.setConsommations(compteurDetails.getConsommations());

        Compteur updatedCompteur = compteurRepository.save(compteur);
        return updatedCompteur;
    }

    @DeleteMapping("/delClient/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Long clientId) {
        Compteur client = compteurRepository.findById(clientId)
                .orElseThrow();

        compteurRepository.delete(client);

        return ResponseEntity.ok().build();
    }
}
