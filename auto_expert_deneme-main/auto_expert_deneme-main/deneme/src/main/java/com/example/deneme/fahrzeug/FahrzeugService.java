package com.example.deneme.fahrzeug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FahrzeugService {
    private final FahrzeugRepo fahrzeugRepo;

    @Autowired
    public FahrzeugService(FahrzeugRepo fahrzeugRepo) {
        this.fahrzeugRepo = fahrzeugRepo;
    }

    public Iterable<Fahrzeug>getFahrzeug(){
        return fahrzeugRepo.findAll();
    }

    public Optional<Fahrzeug> fahrzeugById(int id){
        return  fahrzeugRepo.findById(id);
    }
    public Optional<Fahrzeug> fahrzeugByKfz(String kfz){
        return fahrzeugRepo.findFahrzeugByKfz(kfz);
    }

    public void   arabaEkle(Fahrzeug fahrezeug){
        fahrezeug.setZustand("Reparatur");
        fahrzeugRepo.save(fahrezeug);
    }


    public String zustandsInfoAktualisieren(String fahrzeug, String kfz) {

        Optional<Fahrzeug> opt = fahrzeugRepo.findFahrzeugByKfz(kfz);
        if (opt.isPresent()){
            Fahrzeug f = opt.get();
            f.setZustand(fahrzeug);
            fahrzeugRepo.save(f);
            return "Zustand ist erfolgreich aktualisiert.";
        }
        else{
            throw new NoSuchElementException("Fahrzeug objesi bulunamadı.");
        }
    }


}
