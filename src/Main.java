import core.PlayerRunes;
import core.SearchEngine;
import gui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import runes.Rune;
import runes.Runeword;

import java.util.Random;


public class Main extends Application {

    Stage window;
    Scene scene;
    PlayerRunesGUIController playerRunesGUIController;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        PlayerRunes playerRunes = new PlayerRunes();
        SearchEngine searchEngine = new SearchEngine();

        Parent root = FXMLLoader.load(getClass().getResource("playerRunesPage.fxml"));
        primaryStage.setTitle("RunewordFinder");
        primaryStage.setResizable(false);

        scene = new Scene(root, 900,600);
        scene.getStylesheets().add(getClass().getResource("fontstyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

         */
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("leaving RunewordFinder", "Are you sure?");
        if (answer) {
            playerRunesGUIController.savePlayerRunes();
            window.close();
        }
    }
}