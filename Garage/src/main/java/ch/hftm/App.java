package ch.hftm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static boolean win = false;

    public static void main(String[] args) {
        Pilot pilot1 = new Pilot("Lüku", 23,100,true);
        Pilot gegner = new Pilot("Dinu",33,100, true);
        Pilot gegner2 = new Pilot("Domi",21,200, true);
        Pilot gegner3 = new Pilot("Nive",31,300, true);
        Fahrzeug R6 = new Fahrzeug("Sport", "Yamaha", "YZF-R6", 5000, 120, 180);
        
        //Fahrzeugwahl//
        Scanner scanner = new Scanner(System.in);
        List<Fahrzeug> fahrzeuge = new ArrayList<>();

        boolean weiterHinzufuegen = true;

        while (weiterHinzufuegen) {
            Fahrzeug fahrzeug = new Fahrzeug();

            System.out.println("Bitte geben Sie die Fahrzeugdetails ein:");

            System.out.print("Typ: ");
            fahrzeug.setTyp(scanner.nextLine());

            System.out.print("Marke: ");
            fahrzeug.setMarke(scanner.nextLine());

            System.out.print("Modell: ");
            fahrzeug.setModell(scanner.nextLine());

            System.out.print("Gewicht: ");
            fahrzeug.setGewicht(scanner.nextInt());

            System.out.print("Leistung: ");
            fahrzeug.setLeistung(scanner.nextInt());

            scanner.nextLine(); // Leere Zeile einlesen

            fahrzeuge.add(fahrzeug);

            System.out.print("Möchten Sie ein weiteres Fahrzeug hinzufügen? (ja/nein): ");
            String antwort = scanner.nextLine();

            if (antwort.equalsIgnoreCase("nein")) {
                weiterHinzufuegen = false;
            }
        }

        System.out.println("Die erstellten Fahrzeuge sind:");
        for (Fahrzeug fahrzeug : fahrzeuge) {
            System.out.println("Typ: " + fahrzeug.getTyp());
            System.out.println("Marke: " + fahrzeug.getMarke());
            System.out.println("Modell: " + fahrzeug.getModell());
            System.out.println("Gewicht: " + fahrzeug.getGewicht());
            System.out.println("Leistung: " + fahrzeug.getLeistung());
            System.out.println("--------------------------");
        }

        //erstes Rennen//
        System.out.println("Sie treten gegen "+ gegner.getName()+"an");
        System.out.println("Bitte wählen Sie ein Fahrzeug aus (Geben Sie die Nummer ein): ");
        int auswahl = scanner.nextInt();
        scanner.nextLine(); // Leere Zeile einlesen
    
        if (auswahl >= 1 && auswahl <= fahrzeuge.size()) {
            Fahrzeug ausgewaehltesFahrzeug = fahrzeuge.get(auswahl - 1);
            System.out.println("Das ausgewählte Fahrzeug ist: " + ausgewaehltesFahrzeug.getMarke() + " " + ausgewaehltesFahrzeug.getModell());
            
            System.out.println("möchten sie mit dem Fahrzeug fahren um Erfahrung zu sammeln?");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                System.out.println("Wie weit möchten sie fahren?");
                pilot1.fahren(ausgewaehltesFahrzeug, scanner.nextInt()); 
            }
            pilot1.rennenFahren(ausgewaehltesFahrzeug, gegner, R6);
        } else {
            System.out.println("Ungültige Auswahl!");
        }
        //--------------//

        //zweites Rennen//
        System.out.println("Sie treten gegen"+ gegner2.getName() +"an");
        System.out.println("Bitte wählen Sie ein Fahrzeug aus (Geben Sie die Nummer ein): ");
        auswahl = scanner.nextInt();
        scanner.nextLine(); // Leere Zeile einlesen
    
        if (auswahl >= 1 && auswahl <= fahrzeuge.size()) {
            Fahrzeug ausgewaehltesFahrzeug = fahrzeuge.get(auswahl - 1);
            System.out.println("Das ausgewählte Fahrzeug ist: " + ausgewaehltesFahrzeug.getMarke() + " " + ausgewaehltesFahrzeug.getModell());
            System.out.println("möchten sie mit dem Fahrzeug fahren um Erfahrung zu sammeln?");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                System.out.println("Wie weit möchten sie fahren?");
                pilot1.fahren(ausgewaehltesFahrzeug, scanner.nextInt());
            } 
            pilot1.rennenFahren(ausgewaehltesFahrzeug, gegner2, R6);
        } 
        else {
            System.out.println("Ungültige Auswahl!");
        }
        //--------------//
        
        //drittes Rennen//
        System.out.println("Sie treten gegen"+ gegner3.getName() +"an");
        System.out.println("Bitte wählen Sie ein Fahrzeug aus (Geben Sie die Nummer ein): ");
        auswahl = scanner.nextInt();
        scanner.nextLine(); // Leere Zeile einlesen
    
        if (auswahl >= 1 && auswahl <= fahrzeuge.size()) {
            Fahrzeug ausgewaehltesFahrzeug = fahrzeuge.get(auswahl - 1);
            System.out.println("Das ausgewählte Fahrzeug ist: " + ausgewaehltesFahrzeug.getMarke() + " " + ausgewaehltesFahrzeug.getModell());
             System.out.println("möchten sie mit dem Fahrzeug fahren um Erfahrung zu sammeln?");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                System.out.println("Wie weit möchten sie fahren?");
                pilot1.fahren(ausgewaehltesFahrzeug, scanner.nextInt());
            } 
            pilot1.rennenFahren(ausgewaehltesFahrzeug, gegner3, R6);
        } 
        else {
            System.out.println("Ungültige Auswahl!");
        }
        //--------------//
        if(pilot1.getGewonnen() >= 3){
            System.out.println("Glückwunsch sie haben gewonnen");
            win = true;
        }
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        if(win == true){
            scene = new Scene(loadFXML("primary"), 640, 480);    
        }
        else{
            scene = new Scene(loadFXML("secondary"), 640, 480);
        }
        stage.setScene(scene);
        stage.show();
    }

    static void setSceneRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
}