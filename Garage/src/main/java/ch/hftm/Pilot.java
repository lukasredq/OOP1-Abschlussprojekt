package ch.hftm;

public class Pilot {
    private int alter;
    private int erfahrung;
    private boolean ergeiz;
    private String name;

    public Pilot(String name, int alter, int erfahrung, boolean ergeiz) {
        this.alter = alter;
        this.erfahrung = erfahrung;
        this.ergeiz = ergeiz;
    }

    public Pilot(String name) {
        this.name = name;
        this.erfahrung = 0;
        this.ergeiz = false;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }

    public boolean isErgeiz() {
        return ergeiz;
    }

    public void setErgeiz(boolean ergeiz) {
        this.ergeiz = ergeiz;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void fahren(Fahrzeug fahrzeug, int distanz) {
        System.out.println("Der Pilot fährt " + distanz + " km mit dem Fahrzeug:");
        System.out.println("Typ: " + fahrzeug.getTyp());
        System.out.println("Marke: " + fahrzeug.getMarke());
        System.out.println("Modell: " + fahrzeug.getModell());

        int alterKilometerstand = fahrzeug.getKilometerstand();
        fahrzeug.setKilometerstand(alterKilometerstand + distanz);

        System.out.println("Neuer Kilometerstand: " + fahrzeug.getKilometerstand());
    }
}

