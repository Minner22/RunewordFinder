package core;

import runes.Rune;
import util.XMLReader;
import util.XMLWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class PlayerRunes {

    private EnumMap<Rune, Integer> playerRunes;
    private static final String ABSOLUTE_FILE_DIRECTORY = "src/res/playerRunes.xml";
    private static final String RES_FILE_DIRECTORY = "res/playerRunes.xml";
    private static final int INITIAL_RUNE_AMOUNT = 0;

    public PlayerRunes() {

        playerRunes = new EnumMap<>(Rune.class);
        Path path = Paths.get(ABSOLUTE_FILE_DIRECTORY);

        if (Files.exists(path)) {
            load(RES_FILE_DIRECTORY);
        } else {
            Stream.of(Rune.values()).forEach(key -> playerRunes.put(key, INITIAL_RUNE_AMOUNT));
        }
    }

    public void addRune(Rune rune) {

        playerRunes.put(rune, playerRunes.get(rune) + 1);
    }

    public void removeRune(Rune rune) {
        if (!(playerRunes.get(rune) <= 0)) {
            playerRunes.put(rune, playerRunes.get(rune) - 1);
        }
    }

    public void save() {
        XMLWriter.savePlayersRunesToXML(playerRunes, ABSOLUTE_FILE_DIRECTORY);
    }

    public EnumMap<Rune, Integer> getPlayerRunes() {
        return playerRunes;
    }

    public void load(String fileDirectory) {
        playerRunes = XMLReader.getPlayerRunesFromXML(fileDirectory);
    }

    public List<Rune> getPlayerRunesAsList() {
        List<Rune> playerRunesAsList = new ArrayList<>();

        for (Map.Entry<Rune, Integer> map : playerRunes.entrySet()) {
            if (map.getValue() > 0) {
                for (int i = 0; i < map.getValue(); i++) {
                    playerRunesAsList.add(map.getKey());
                }
            }
        }

        return playerRunesAsList;
    }

    public void resetPlayerRunes() {
        playerRunes.forEach((key, value) -> playerRunes.put(key, INITIAL_RUNE_AMOUNT) );
    }

    public int getAmount(Rune rune) {
        return playerRunes.get(rune);
    }
}
