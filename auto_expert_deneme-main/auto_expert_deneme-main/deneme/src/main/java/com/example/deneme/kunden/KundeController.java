package com.example.deneme.kunden;

import com.example.deneme.fahrzeug.Fahrzeug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KundeController {
    private KundeService kundeService;

    @Autowired
    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping("/kunde/list")
    public Iterable<Kunde> kundelist(){
        return kundeService.getkundelist();
    }

    @PostMapping("/kunde/ekle")
    public void kundeEkle(@RequestBody Kunde k){
        kundeService.kundeekle(k);
    }
}
