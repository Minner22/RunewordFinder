package gui;

import items.ItemType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import runes.Rune;
import runes.Runeword;

import java.util.ArrayList;
import java.util.List;

public class RunewordGUI extends VBox {
    private Label runewordName;
    private final Runeword runeword;
    private VBox runewordVBox;
    private List<Label> runeNames;
    private List<ImageView> runeImages;
    private List<VBox> runeVBox;
    private static final int SPACING = 5;


    //TODO: new window with runeword properties and item types.
    public RunewordGUI(Runeword runeword) {
        super(SPACING);
        this.runeword = runeword;
        //runewordVBox = new VBox(SPACING);
        this.setAlignment(Pos.CENTER_LEFT);

        List<Rune> runes = runeword.getRunes();
        HBox runewordHBox = new HBox(SPACING);
        runewordHBox.setAlignment(Pos.CENTER_LEFT);

        runeNames = new ArrayList<>(runeword.getRuneCount());
        runeImages = new ArrayList<>(runeword.getRuneCount());
        runeVBox = new ArrayList<>(runeword.getRuneCount());

        for (Rune rune : runes) {
            ImageView imageView = new ImageView(rune.getImage());
            Tooltip.install(imageView, new Tooltip(rune.getProperties()));
            runeNames.add(new Label(rune.name()));
            runeImages.add(imageView);

        }

        for (int i = 0; i < runeNames.size(); i++) {
            VBox vBox = new VBox(SPACING);
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(runeImages.get(i), runeNames.get(i));
            runeVBox.add(vBox);
        }

        for (int i = 0; i < runeVBox.size(); i++) {
            runewordHBox.getChildren().add(runeVBox.get(i));
            if(!(i + 1 == runeVBox.size())) {
                runewordHBox.getChildren().add(new Label("+"));
            }
        }

        runewordName = new Label(runeword.getName());

        this.getChildren().addAll(runewordName, runewordHBox);

    }

    public VBox getRunewordVBox() {
        return runewordVBox;
    }

    public void getRunewordDetails() {

        Stage runewordDetails = new Stage();
        runewordDetails.setTitle(runeword.getName());

        VBox runewordDetailsVBox = new VBox(SPACING);
        runewordDetailsVBox.setAlignment(Pos.CENTER);

        Label name = new Label(runeword.getName());
        name.setStyle("-fx-font-size: 16pt");
        Label reqLevel = new Label("Required Level: " + runeword.getLevel());
        reqLevel.setStyle("-fx-text-fill: #ffffff");
        Label properties = new Label(runeword.getProperties());
        properties.setStyle("-fx-text-fill: #101093");
        properties.setTextAlignment(TextAlignment.CENTER);
        Label itemTypesHeader = new Label("Item type:");
        itemTypesHeader.setStyle("-fx-text-fill: #ffffff");

        HBox runeImgs = new HBox(SPACING);
        runeImgs.setAlignment(Pos.CENTER);
        for (Rune rune : runeword.getRunes()) {
            ImageView img = new ImageView(rune.getImage());
            Tooltip.install(img, new Tooltip(rune.getProperties()));
            runeImgs.getChildren().add(img);
        }

        StringBuilder itemTypes = new StringBuilder();
        for (ItemType it : runeword.getTypes()) {
            itemTypes.append(it.getName()).append("\n");
        }

        Label itemTypesBody = new Label(itemTypes.toString());
        itemTypesBody.setStyle("-fx-text-fill: #ffffff");

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> runewordDetails.close());

        runewordDetailsVBox.getChildren().addAll(name, runeImgs, reqLevel, properties, itemTypesHeader, itemTypesBody, exitButton);

        Scene scene = new Scene(runewordDetailsVBox);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("fontstyle.css").toExternalForm());
        runewordDetails.setScene(scene);
        runewordDetails.showAndWait();

    }
}
