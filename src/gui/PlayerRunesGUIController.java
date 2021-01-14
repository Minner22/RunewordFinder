package gui;

import core.PlayerRunes;
import core.SearchEngine;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import runes.Rune;
import runes.Runeword;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerRunesGUIController implements Initializable {
    public Button searchWindowButton;
    public Button playerRunesWindowButton;

    public ScrollPane playerRunesScrollPane;
    public ScrollPane possibleRunewordsScrollPane;
    public Button resetButton;

    private PlayerRunes playerRunes;
    private SearchEngine searchEngine;
    ListView<VBox> runewordsListView;
    private static final int SPACING = 5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.playerRunes = new PlayerRunes();
        this.searchEngine = new SearchEngine(playerRunes);
        runewordsListView = new ListView<>();

        generateRunewordListView();
        possibleRunewordsScrollPane.setContent(runewordsListView);


        //player runes manipulator
        VBox playerRunesVBox = new VBox(SPACING);
        playerRunesVBox.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        for (Rune rune : Rune.values()) {
            playerRunesVBox.getChildren().add(generateRuneHBox(rune));
        }

        playerRunesScrollPane.setContent(playerRunesVBox);

    }

    private void generateRunewordListView() {
        List<Runeword> runewordList = searchEngine.getRunewordsPlayerCanMake();
        List<VBox> generatedRunewords = new ArrayList<>();
        for (Runeword runeword : runewordList) {
            generatedRunewords.add(new RunewordGUI(runeword).getRunewordVBox());
        }
        for (VBox vBox : generatedRunewords) {
            runewordsListView.getItems().add(vBox);
        }
    }

    private HBox generateRuneHBox(Rune rune) {
        HBox runeHBox = new HBox(SPACING);
        Label runeAmount = new Label(String.valueOf(playerRunes.getAmount(rune)));
        ImageView img = new ImageView(rune.getImage());
        Label runeName = new Label(rune.name());
        Button addRuneButton = new Button("+");
        Region fillerRegion = new Region();
        Button removeRuneButton = new Button("-");

        Tooltip.install(img, new Tooltip(rune.getProperties()));
        runeAmount.setPrefWidth(20);
        runeHBox.setAlignment(Pos.CENTER_LEFT);
        removeRuneButton.setOnAction(e -> {
            playerRunes.removeRune(rune);
            runeAmount.setText(String.valueOf(playerRunes.getAmount(rune)));
            runewordsListView.refresh();
            update();
        });

        addRuneButton.setOnAction(e -> {
            playerRunes.addRune(rune);
            runeAmount.setText(String.valueOf(playerRunes.getAmount(rune)));
            update();
            runewordsListView.refresh();
        });

        runeHBox.setHgrow(fillerRegion, Priority.ALWAYS);
        runeHBox.getChildren().addAll(img, runeName, fillerRegion, removeRuneButton, runeAmount, addRuneButton);

        return runeHBox;
    }

    public void resetPlayerRunes() {
        playerRunes.resetPlayerRunes();
        update();
        runewordsListView.refresh();

        VBox temp = (VBox) playerRunesScrollPane.getContent();
        ObservableList<Node> tempList = temp.getChildren();
        for (Node node : tempList) {
            HBox tempHbox = (HBox) node;
            Label tempLabel = (Label) tempHbox.getChildren().get(4);
            tempLabel.setText("0");
        }
    }

    public void savePlayerRunes() {
        playerRunes.save();
        runewordsListView.refresh();
        update();
    }

    private void update() {
        runewordsListView.getItems().clear();
        generateRunewordListView();
        possibleRunewordsScrollPane.setContent(runewordsListView);
    }
}
