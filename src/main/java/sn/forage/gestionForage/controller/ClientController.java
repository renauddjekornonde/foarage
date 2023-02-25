package sn.forage.gestionForage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forage.gestionForage.model.Abonnement;
import sn.forage.gestionForage.model.Clients;
import sn.forage.gestionForage.repository.ClientRepository;

import java.util.List;
import java.util.Optional;


public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public List<Clients> getAllClient(){
        return clientRepository.findAll();
    }

    @PostMapping("/createclient")
    public Clients createClient(@RequestBody Clients client) {
        return clientRepository.save(client);
    }

    @GetMapping("/client/{id}")
    public Optional<Clients> getClientById(@PathVariable(value = "id") Long clientId) {
        return clientRepository.findById(clientId);
    }

    @PutMapping("/clients/{id}")
    public Clients updateClients(@PathVariable(value = "id") Long clientId,
                                 @RequestBody Clients clientDetails) {
        Clients client = clientRepository.findById(clientId)
                .orElseThrow();

        client.setNomFamille(clientDetails.getNomFamille());
        client.setVillage(clientDetails.getVillage());
        client.setNumTel(clientDetails.getNumTel());

        Clients updatedClients = clientRepository.save(client);
        return updatedClients;
    }

    @DeleteMapping("/delClient/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Long clientId) {
        Clients client = clientRepository.findById(clientId)
                .orElseThrow();

        clientRepository.delete(client);

        return ResponseEntity.ok().build();
    }
}
