package Objects;

public class Fahrzeug {
    //private int id;
    private String kfz;
    private String marka;
    private String Zustand;
    private String reparaturen = "atandi";
    private String Kosten = "atandi";
    private String Schade;


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

    public String getReparaturen() {
        return reparaturen;
    }

    public void setReparaturen(String reparaturen) {
        this.reparaturen = reparaturen;
    }

    public String getKosten() {
        return Kosten;
    }

    public void setKosten(String kosten) {
        Kosten = kosten;
    }

    public String getSchade() {
        return Schade;
    }

    public void setSchade(String schade) {
        Schade = schade;
    }
}
