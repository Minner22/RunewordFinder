package gui;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import runes.Rune;
import runes.Runeword;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RunewordGUI {
    private Label runewordName;
    private final Runeword runeword;
    private VBox runewordVBox;
    private List<Label> runeNames;
    private List<ImageView> runeImages;
    private List<VBox> runeVBox;
    private static final int SPACING = 5;


    //TODO: new window with runeword properties and item types.
    public RunewordGUI(Runeword runeword) {
        this.runeword = runeword;
        runewordVBox = new VBox(SPACING);
        runewordVBox.setAlignment(Pos.CENTER_LEFT);

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

        runewordVBox.getChildren().addAll(runewordName, runewordHBox);

    }

    public VBox getRunewordVBox() {
        return runewordVBox;
    }

    public void update() {

    }
}
