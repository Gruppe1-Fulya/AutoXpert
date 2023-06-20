package com.example.deneme.kunden;

import com.example.deneme.fahrzeug.Fahrzeug;
import com.example.deneme.fahrzeug.FahrzeugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KundeService  {

    private final KundeRepo kundeRepo;
    private final FahrzeugRepo fahrzeugRepoRepo;

    @Autowired
    public KundeService(KundeRepo kundeRepo, FahrzeugRepo fahrzeugRepoRepo) {
        this.kundeRepo = kundeRepo;
        this.fahrzeugRepoRepo = fahrzeugRepoRepo;
    }

    public Iterable<Kunde> getkundelist() {
        return kundeRepo.getAllKunde();
    }

    public void kundeekle(Kunde k) {
        Fahrzeug fahrzeug = k.getFahrzeug();
        fahrzeug.setZustand("Reparatur");
        k.setFahrzeug(fahrzeug);
        fahrzeug.setKunde(k);
        fahrzeugRepoRepo.save(fahrzeug);
        kundeRepo.save(k);
    }
}
