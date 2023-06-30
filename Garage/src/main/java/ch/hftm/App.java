package ch.hftm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) {
        // Test der Fahrzeug Klasse
        Fahrzeug R6 = new Fahrzeug("Enduro", "Yamaha", "YZF-R6", 5000, 120, 180);
        System.out.println("Alter Typ: " + R6.getTyp());
        R6.setTyp("Sport");
        System.out.println("Alter Typ: " + R6.getTyp());
        
        // Test der Pilot Klasse
        Pilot pilot1 = new Pilot("ädu",30, 10, true);
        System.out.println("Alter des Piloten 1: " + pilot1.getAlter());
        System.out.println("Erfahrung des Piloten 1: " + pilot1.getErfahrung());
        System.out.println("Ergeiz des Piloten 1: " + pilot1.isErgeiz());

        Pilot pilot2 = new Pilot("peschä");
        System.out.println("Alter des Piloten 2: " + pilot2.getAlter());
        System.out.println("Erfahrung des Piloten 2: " + pilot2.getErfahrung());
        System.out.println("Ergeiz des Piloten 2: " + pilot2.isErgeiz());
        pilot1.fahren(R6, 100);

        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
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