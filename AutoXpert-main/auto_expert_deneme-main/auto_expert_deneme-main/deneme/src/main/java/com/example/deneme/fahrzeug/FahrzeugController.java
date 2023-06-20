package com.example.deneme.fahrzeug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FahrzeugController {

    private final FahrzeugService fahrzeugService;


    @Autowired
    public FahrzeugController(FahrzeugService fahrzeugService) {
        this.fahrzeugService = fahrzeugService;
    }

    @GetMapping("/araba/get")
    public Iterable<Fahrzeug> getAraba(){
        return fahrzeugService.getFahrzeug();
    }

    @GetMapping("/araba/get/{id}")
    public Optional<Fahrzeug> getById(@PathVariable int id){
        return fahrzeugService.fahrzeugById(id);
    }

    @PostMapping("/araba/ekle")
    public void postAraba(@RequestBody Fahrzeug f){
        fahrzeugService.arabaEkle(f);
    }

    @PutMapping("/araba/zsAktu/{Kfz}")
    public String zuStandInfoAktu(@RequestBody Fahrzeug fahrzeug ,@PathVariable String Kfz){
          return fahrzeugService.zustandsInfoAktualisieren(String.valueOf(fahrzeug), Kfz);
    }

    @GetMapping("/araba/getKFZ/{kfz}") //++
    public Optional<Fahrzeug> getByKFZ(@PathVariable String kfz){
        return fahrzeugService.fahrzeugByKfz(kfz);
    }

    @PutMapping("/araba/fahrzeugAktu/{Kfz}") //+++
    public String FahrzeugAktu(@RequestBody Fahrzeug fahrzeug ,@PathVariable String Kfz){
        return fahrzeugService.fahrzeugAktu(fahrzeug, Kfz);
    }



}
