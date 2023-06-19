package com.example.deneme.fahrzeug;

import com.example.deneme.kunden.Kunde;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class Fahrzeug {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String kfz;
    private String marka;

    private String Zustand;

    private String reparaturen;

    private String Kosten;

    private String Schade;
    @OneToOne(mappedBy = "fahrzeug", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Kunde kunde;
    public Fahrzeug(int id, String kfz) {
        this.id = id;
        this.kfz = kfz;
        this.marka = marka;
        this.reparaturen = reparaturen;
        this.Kosten = Kosten;
    }

    public Fahrzeug() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKfz() {
        return kfz;
    }

    public void setKfz(String kfz) {
        this.kfz = kfz;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getZustand() {
        return Zustand;
    }

    public void setZustand(String zustand) {
        Zustand = zustand;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public String getReparaturen() {
        return reparaturen;
    }
    public String getKosten() {
        return Kosten;
    }
}
