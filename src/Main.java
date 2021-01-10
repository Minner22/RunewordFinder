import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import util.XMLReader;


public class Main extends Application {

    Stage window;
    Scene s1, s2;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("RunewordFinder");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Button exit = new Button("Exit");
        exit.setOnAction(e -> closeProgram());

        Label label1 = new Label("this is first scene");
        Button button1 = new Button("use 2nd scene");
        button1.setOnAction(e-> window.setScene(s2));

        Button conBox = new Button("question");
        conBox.setOnAction(e ->  {
            boolean result = ConfirmBox.display("Diablo", "Do you like Diablo 2");
            System.out.println(result);
        });

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label1, button1, conBox, exit);
        s1 = new Scene(layout1, 300,300);
        s1.getStylesheets().add(getClass().getResource("fontstyle.css").toExternalForm());

        Button button2 = new Button("alert");
        button2.setOnAction(e -> AlertBox.display("Alert", "Testing alert windows"));

        Button button3 = new Button("go back");
        button3.setOnAction(e -> window.setScene(s1));

        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(button2, button3, exit);
        s2 = new Scene(layout2, 200,200);
        s2.getStylesheets().add(getClass().getResource("fontstyle.css").toExternalForm());

        window.setScene(s1);
        window.show();
        XMLReader xmlReader = new XMLReader();
        xmlReader.testParser();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("leaving RunewordFinder", "Are you sure?");
        if (answer) {
            System.out.println("here save config with users runes");
            window.close();
        }
    }
}