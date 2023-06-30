package ch.hftm;

import java.util.Scanner;

public class Fahrzeug {
    private String typ;
    private String marke;
    private String modell;
    private int kilometerstand;
    private int leistung;
    private int gewicht;

    public Fahrzeug(String typ, String marke, String modell, int kilometerstand, int leistung, int gewicht) {
        this.typ = typ;
        this.marke = marke;
        this.modell = modell;
        this.kilometerstand = kilometerstand;
        this.leistung = leistung;
        this.gewicht = gewicht;
    }

    public Fahrzeug() {
        this.kilometerstand = 0;
        this.leistung = 0;
        this.gewicht = 0;
    }

    // Getter-Methoden
    public String getTyp() {
        return typ;
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public int getLeistung() {
        return leistung;
    }

    public int getGewicht() {
        return gewicht;
    }

    // Setter-Methoden
    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public void setLeistung(int leistung) {
        this.leistung = leistung;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return "Typ: " + typ + "\nMarke: " + marke + "\nModell: " + modell + "\nKilometerstand: " + kilometerstand +
                "\nLeistung: " + leistung + " PS" + "\nGewicht: " + gewicht + " kg";
    }
}
