package core;

import runes.Rune;
import runes.Runeword;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private PlayerRunes playerRunes;

    public SearchEngine() {
        playerRunes =  new PlayerRunes();
    }

    public SearchEngine(PlayerRunes playerRunes) {
        this.playerRunes = playerRunes;
    }

    public List<Runeword> getRunewordsPlayerCanMake() {
        List<Runeword> runewords =  new ArrayList<>();
        List<Rune> playerRunesAsList = playerRunes.getPlayerRunesAsList();

        for (Runeword runeword : Runeword.values()) {
            if (playerRunesAsList.containsAll(runeword.getRunes())) {
                runewords.add(runeword);
            }
        }
        return  runewords;
    }
}
