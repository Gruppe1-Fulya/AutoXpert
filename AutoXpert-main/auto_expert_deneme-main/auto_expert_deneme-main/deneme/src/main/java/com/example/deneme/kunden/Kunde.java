package com.example.deneme.kunden;

import com.example.deneme.fahrzeug.Fahrzeug;
import jakarta.persistence.*;

@Entity
@Table
public class Kunde {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String nachname;
    @OneToOne
    @JoinColumn(name = "fahrzeug_id")
    private Fahrzeug fahrzeug;


    /*public Kunde(){
        this.fahrzeug = new Fahrzeug();
        this.fahrzeug.setKunde(this);
    }*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

}
