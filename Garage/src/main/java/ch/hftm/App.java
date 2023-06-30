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
        Fahrzeug R6 = new Fahrzeug("Sport", "Yamaha", "YZF-R6", 5000, 120, 180);
        Fahrzeug zx6r = new Fahrzeug("Sport", "kawasaki", "zx6r", 5000, 115, 185);

        // Test der Pilot Klasse
        Pilot pilot1 = new Pilot("ädu",30, 10, true);
        Pilot pilot2 = new Pilot("peschä");
        pilot1.fahren(R6, 100);
        pilot1.rennenFahren(R6, pilot2, R6);

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