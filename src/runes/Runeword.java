package runes;

import items.ItemType;
import static items.ItemType.*;
import static runes.Rune.*;

import items.ItemTypeContainer;
import util.XMLReader;

import java.util.*;

public enum Runeword {

    /* Original Runewords */
    ANCIENTS_PLEDGE("Ancient's Pledge", 21, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(RAL, ORT, TAL))),
    BLACK("Black", 35, new HashSet<>(Arrays.asList(CLUB, HAMMER, MACE)), new ArrayList<>(Arrays.asList(THUL, IO, NEF))),
    FURY("Fury", 65, ItemTypeContainer.MELEE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(JAH, GUL, ETH))),
    HOLY_THUNDER("Holy Thunder", 23, new HashSet<>(Collections.singletonList(SCEPTER)), new ArrayList<>(Arrays.asList(ETH, RAL, ORT, TAL))),
    HONOR("Honor", 27, ItemTypeContainer.MELEE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(AMN, EL, ITH, TIR, SOL))),
    KINGS_GRACE("King's Grace", 25, new HashSet<>(Arrays.asList(SWORD, SCEPTER)), new ArrayList<>(Arrays.asList(AMN, RAL, THUL))),
    LEAF("Leaf", 19, new HashSet<>(Collections.singletonList(STAFF)), new ArrayList<>(Arrays.asList(TIR, RAL))),
    LIONHEART("Lionheart", 41, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(HEL, LUM, FAL))),
    LORE("Lore", 27, new HashSet<>(Collections.singletonList(HELM)), new ArrayList<>(Arrays.asList(ORT, SOL))),
    MALICE("Malice", 15, ItemTypeContainer.MELEE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(ITH, EL, ETH))),
    MELODY("Melody", 39, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(SHAEL, KO, NEF))),
    MEMORY("Memory", 37, new HashSet<>(Collections.singletonList(STAFF)), new ArrayList<>(Arrays.asList(LUM, IO, SOL, ETH))),
    NADIR("Nadir", 13, new HashSet<>(Collections.singletonList(HELM)), new ArrayList<>(Arrays.asList(NEF, TIR))),
    RADIANCE("Radiance", 27, new HashSet<>(Collections.singletonList(HELM)), new ArrayList<>(Arrays.asList(NEF, SOL, ITH))),
    RHYME("Rhyme", 29, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(SHAEL, ETH))),
    SILENCE("Silence", 55, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(DOL, ELD, HEL, IST, TIR, VEX))),
    SMOKE("Smoke", 37, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(NEF, LUM))),
    STEALTH("Stealth", 17, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(TAL, ETH))),
    STEEL("Steel", 13, new HashSet<>(Arrays.asList(SWORD, AXE, MACE)), new ArrayList<>(Arrays.asList(TIR, EL))),
    STRENGTH("Strength", 25, ItemTypeContainer.MELEE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(AMN, TIR))),
    VENOM("Venom", 49, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(TAL, DOL, MAL))),
    WEALTH("Wealth", 43, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(LEM, KO, TIR))),
    WHITE("White", 35, new HashSet<>(Collections.singletonList(WAND)), new ArrayList<>(Arrays.asList(DOL, IO))),
    ZEPHYR("Zephyr", 21, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(ORT, ETH))),

    /* 1.10 Runewords */
    BEAST("Beast", 63, new HashSet<>(Arrays.asList(AXE, SCEPTER, HAMMER)), new ArrayList<>(Arrays.asList(BER, TIR, UM, MAL, LUM))),
    BRAMBLE("Bramble", 61, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(RAL, OHM, SUR, ETH))),
    BREATH_OF_THE_DYING("Breath of the Dying", 69, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(VEX, HEL, EL, ELD, ZOD, ETH))),
    CALL_TO_ARMS("Call to Arms", 57, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(AMN, RAL, MAL, IST, OHM))),
    CHAINS_OF_HONOR("Chains of Honor", 63, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(DOL, UM, BER, IST))),
    CHAOS("Chaos", 57, new HashSet<>(Collections.singletonList(CLAW)), new ArrayList<>(Arrays.asList(FAL, OHM, UM))),
    CRESCENT_MOON("Crescent Moon", 47, new HashSet<>(Arrays.asList(AXE, SWORD, POLEARM)), new ArrayList<>(Arrays.asList(SHAEL, UM, TIR))),
    DELIRIUM("Delirium", 51, new HashSet<>(Collections.singletonList(HELM)), new ArrayList<>(Arrays.asList(LEM, IST, KO))),
    DOOM("Doom", 67, new HashSet<>(Arrays.asList(AXE, POLEARM, HAMMER)), new ArrayList<>(Arrays.asList(HEL, OHM, UM, LO, CHAM))),
    DURESS("Duress", 47, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(SHAEL, UM, THUL))),
    ENIGMA("Enigma", 65, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(JAH, ITH, BER))),
    ETERNITY("Eternity", 63, ItemTypeContainer.MELEE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(AMN, BER, IST, SOL, SUR))),
    EXILE("Exile", 57, new HashSet<>(Collections.singletonList(PALA_SHIELD)), new ArrayList<>(Arrays.asList(VEX, OHM, IST, DOL))),
    FAMINE("Famine", 65, new HashSet<>(Arrays.asList(AXE, HAMMER)), new ArrayList<>(Arrays.asList(FAL, OHM, ORT, JAH))),
    GLOOM("Gloom", 47, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(FAL, UM, PUL))),
    HAND_OF_JUSTICE("Hand of Justice", 67, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(SUR, CHAM, AMN, LO))),
    HEART_OF_THE_OAK("Heart of the Oak", 55, new HashSet<>(Arrays.asList(STAFF, MACE)), new ArrayList<>(Arrays.asList(KO, VEX, PUL, THUL))),
    KINGSLAYER("Kingslayer", 53, new HashSet<>(Arrays.asList(SWORD, AXE)), new ArrayList<>(Arrays.asList(MAL, UM, GUL, FAL))),
    PASSION("Passion", 43, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(DOL, ORT, ELD, LEM))),
    PRUDENCE("Prudence", 49, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(MAL, TIR))),
    SANCTUARY("Sanctuary", 49, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(KO, KO, MAL))),
    SPLENDOR("Splendor", 37, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(ETH, LUM))),
    STONE("Stone", 47, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(SHAEL, UM, PUL, LUM))),
    WIND("Wind", 61, ItemTypeContainer.MELEE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(SUR, EL))),

    /* 1.10 Runewords (Ladder Only) */
    BRAND("Brand", 65, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(JAH, LO, MAL, GUL))),
    DEATH("Death", 55, new HashSet<>(Arrays.asList(SWORD, AXE)), new ArrayList<>(Arrays.asList(HEL, EL, VEX, ORT, GUL))),
    DESTRUCTION("Destruction", 65, new HashSet<>(Arrays.asList(POLEARM, SWORD)), new ArrayList<>(Arrays.asList(VEX, LO, BER, JAH, KO))),
    DRAGON_ARMOR("Dragon", 61, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(SUR, LO, SOL))),
    DRAGON_SHIELD("Dragon", 61, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(SUR, LO, SOL))),
    DREAM_HELMET("Dream", 65, new HashSet<>(Collections.singletonList(HELM)), new ArrayList<>(Arrays.asList(IO, JAH, PUL))),
    DREAM_SHIELD("Dream", 65, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(IO, JAH, PUL))),
    EDGE("Edge", 25, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(TIR, TAL, AMN))),
    FAITH("Faith", 65, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(OHM, JAH, LEM, ELD))),
    FORTITUDE_ARMOR("Fortitude", 59, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(EL, SOL, DOL, LO))),
    FORTITUDE_WEAPON("Fortitude", 59, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(EL, SOL, DOL, LO))),
    GRIEF("Grief", 59, new HashSet<>(Arrays.asList(SWORD, AXE)), new ArrayList<>(Arrays.asList(ETH, TIR, LO, MAL, RAL))),
    HARMONY("Harmony", 39, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(TIR, ITH, SOL, KO))),
    ICE("Ice", 65, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(AMN, SHAEL, JAH, LO))),
    INFINITY("Infinity", 63, new HashSet<>(Collections.singletonList(POLEARM)), new ArrayList<>(Arrays.asList(BER, MAL, BER, IST))),
    INSIGHT("Insight", 27, new HashSet<>(Arrays.asList(POLEARM, STAFF)), new ArrayList<>(Arrays.asList(RAL, TIR, TAL, SOL))),
    LAST_WISH("Last Wish", 65, new HashSet<>(Arrays.asList(SWORD, HAMMER, AXE)), new ArrayList<>(Arrays.asList(JAH, MAL, JAH, SUR, JAH, BER))),
    LAWBRINGER("Lawbringer", 43, new HashSet<>(Arrays.asList(SWORD, HAMMER, SCEPTER)), new ArrayList<>(Arrays.asList(AMN, LEM, KO))),
    OATH("Oath", 59, new HashSet<>(Arrays.asList(SWORD, AXE, MACE)), new ArrayList<>(Arrays.asList(SHAEL, PUL, MAL, LUM))),
    OBEDIENCE("Obedience", 41, new HashSet<>(Collections.singletonList(POLEARM)), new ArrayList<>(Arrays.asList(HEL, KO, THUL, ETH, FAL))),
    PHOENIX_WEAPON("Phoenix", 65, ItemTypeContainer.WEAPON.getTypes(), new ArrayList<>(Arrays.asList(VEX, VEX, LO, JAH))),
    PHOENIX_SHIELD("Phoenix", 65, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(VEX, VEX, LO, JAH))),
    PRIDE("Pride", 67, new HashSet<>(Collections.singletonList(POLEARM)), new ArrayList<>(Arrays.asList(CHAM, SUR, IO, LO))),
    RIFT("Rift", 53, new HashSet<>(Arrays.asList(POLEARM, SCEPTER)), new ArrayList<>(Arrays.asList(HEL, KO, LEM, GUL))),
    SPIRIT_SWORD("Spirit", 25, new HashSet<>(Collections.singletonList(SWORD)), new ArrayList<>(Arrays.asList(TAL, THUL, ORT, AMN))),
    SPIRIT_SHIELD("Spirit", 25, ItemTypeContainer.SHIELD.getTypes(), new ArrayList<>(Arrays.asList(TAL, THUL, ORT, AMN))),
    VOICE_OF_REASON("Voice of Reason", 43, new HashSet<>(Arrays.asList(SWORD, MACE)), new ArrayList<>(Arrays.asList(LEM, KO, EL, ELD))),
    WRATH("Wrath", 63, ItemTypeContainer.MISSILE_WEAPON.getTypes(), new ArrayList<>(Arrays.asList(PUL, LUM, BER, MAL))),

    /* 1.11 Runewords */
    BONE("Bone", 47, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(SOL, UM, UM))),
    ENLIGHTENMENT("Enlightenment", 45, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(PUL, RAL, SOL))),
    MYTH("Myth", 25, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(HEL, AMN, NEF))),
    PEACE("Peace", 29, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(SHAEL, THUL, AMN))),
    PRINCIPLE("Principle", 55, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(RAL, GUL, ELD))),
    RAIN("Rain", 49, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(ORT, MAL, ITH))),
    TREACHERY("Treachery", 43, new HashSet<>(Collections.singletonList(BODY_ARMOR)), new ArrayList<>(Arrays.asList(SHAEL, THUL, LEM)));

    private final String name;
    private final int level;
    private final Set<ItemType> types;
    private final ArrayList<Rune> runes;
    private final String properties;

    Runeword(String name, int level, Set<ItemType> types, ArrayList<Rune> runes) {
        this.name = name;
        this.level = level;
        this.types = types;
        this.runes = runes;

        String tempProp = "";
        //XMLReader xmlReader = new XMLReader();
        try {
            XMLReader xmlReader = new XMLReader();
            tempProp = xmlReader.getXMLRunewordProp(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
        properties = tempProp;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Set<ItemType> getTypes() {
        return Collections.unmodifiableSet(types);
    }

    public ArrayList<Rune> getRunes() {
        return (ArrayList<Rune>) Collections.unmodifiableList(runes);
    }

    public String getProperties() {
        return properties;
    }
}
