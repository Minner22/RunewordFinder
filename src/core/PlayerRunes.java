package core;

import runes.Rune;
import util.XMLReader;
import util.XMLWriter;

import java.util.Collections;
import java.util.EnumMap;
import java.util.stream.Stream;

public class PlayerRunes {

    private EnumMap<Rune, Integer> playerRunes;
    private String fileDirectory;
    private static final int INITIAL_RUNE_AMOUNT = 0;

    public PlayerRunes() {

        fileDirectory = "res/playerRunes.xml";

        playerRunes = new EnumMap<>(Rune.class);

        Stream.of(Rune.values()).forEach(key -> playerRunes.put(key, INITIAL_RUNE_AMOUNT));

        for (Rune rune : Rune.values()) {
            playerRunes.put(rune, INITIAL_RUNE_AMOUNT);
        }
    }

    /*
    PlayerRunes(EnumMap<Rune, Integer> playerRunes) {
        this.playerRunes = playerRunes;
    }
     */

    public void addRune(Rune rune) {
        playerRunes.put(rune, playerRunes.get(rune) + 1);
    }

    public void removeRune(Rune rune) {
        if (!(playerRunes.get(rune) <= 0)) {
            playerRunes.put(rune, playerRunes.get(rune) - 1);
        }
    }

    public void save() {
        XMLWriter.savePlayersRunesToXML(playerRunes, fileDirectory);
    }

    public EnumMap<Rune, Integer> getPlayerRunes() {
        return playerRunes;
    }

    public void load() {
        playerRunes = XMLReader.getPlayerRunesFromXML(fileDirectory);
    }
}
