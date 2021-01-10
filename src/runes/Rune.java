package runes;

public enum Rune {

    EL("El", "+50 AR, +1 Light Radius", " +1 Light Radius, +15 Defense","runeImg/r01_El.gif", 11),
    ELD("Eld", "+75% Damage vs. Undead, +50 Attack Rating vs. Undead","Lowers Stamina drain by 15%","+7% Blocking", "runeImg/r02_Eld.gif", 11),
    TIR("Tir","+2 Mana Per Kill","+2 Mana Per Kill", "runeImg/r03_Tir.gif", 13),
    NEF("Nef","Knockback","+30 Defense vs. Missile","runeImg/r04_Nef.gif",13),
    ETH("Eth","-25% Target Defense","Regenerate Mana 15%","runeImg/r05_Eth.gif",15),
    ITH("Ith","+9 to Maximum Damage","15% Damage Taken Goes to Mana","runeImg/r06_Ith.gif",15),
    TAL("Tal","75 Poison damage over 5 seconds","+35% Poison Resistance","runeImg/r07_Tal.gif",17),
    RAL("Ral","+5-30 Fire Damage","+35% Fire Resistance","runeImg/r08_Ral.gif",19),
    ORT("Ort","+1-50 Lightning Damage","+35% Lightning Resistance","runeImg/r09_Ort.gif",21),
    THUL("Thul","+3-14 Cold Damage (Cold Length 3 seconds)","+35% Cold Resistance","runeImg/r10_Thul.gif",23),
    AMN("Amn","7% Life Stolen Per Hit","Attacker takes 14 damage","runeImg/r11_Amn.gif",25),
    SOL("Sol","+9 to Minimum Damage","-7 Damage Taken","runeImg/r12_Sol.gif",27),
    SHAEL("Shael","Faster Attack Rate (+20)","Faster Hit Recovery (+20)","Faster Block Rate (+20)","runeImg/r13_Shael.gif",29),
    DOL("Dol","25% Chance that Hit Causes Monster to Flee","+7 Replenish Life","runeImg/r14_Dol.gif",31),
    HEL("Hel","-20% Requirements","-15% Requirements","runeImg/r15_Hel.gif",0),
    IO("Io","+10 Vitality","+10 Vitality","runeImg/r16_Io.gif",35),
    LUM("Lum","+10 Energy","+10 Energy","runeImg/r17_Lum.gif",37),
    KO("Ko","+10 Dexterity","+10 Dexterity","runeImg/r18_Ko.gif",39),
    FAL("Fal","+10 Strength","+10 Strength","runeImg/r19_Fal.gif",41),
    LEM("Lem","+75% Extra Gold from Monsters","+50% Extra Gold from Monsters","runeImg/r20_Lem.gif",43),
    PUL("Pul","+75% Damage to Demons, +100 AR against Demons","+30% Defense","runeImg/r21_Pul.gif",45),
    UM("Um","25% Chance of Open Wounds","+15% Resist All","+22% Resist All","runeImg/r22_Um.gif",47),
    MAL("Mal","Prevent Monster Healing","Reduce Magic Damage by 7","runeImg/r23_Mal.gif",49),
    IST("Ist","+30% Better Chance of Finding Magical Items","+25% Better Chance of Finding Magical Items","runeImg/r24_Ist.gif",51),
    GUL("Gul","+20% AR","+5 to Max Resist Poison","runeImg/r25_Gul.gif",53),
    VEX("Vex","7% Mana Leech","+5 to Max Fire Resist","runeImg/r26_Vex.gif",55),
    OHM("Ohm","+50% Damage","+5 to Max. Resist Cold","runeImg/r27_Ohm.gif",57),
    LO("Lo","20% Chance of Deadly Strike","+5 to Max. Resist Lightning","runeImg/r28_Lo.gif",59),
    SUR("Sur","20% Chance of Hit Blinds Target","+5% total Mana","+50 Mana","runeImg/r29_Sur.gif",61),
    BER("Ber","20% Chance of Crushing Blow","Damage Reduced by 8%","runeImg/r30_Ber.gif",63),
    JAH("Jah","Ignores Target Defense","+5% of total Hit Points","+50 Hit Points","runeImg/r31_Jah.gif",65),
    CHAM("Cham","32% Chance of Hit Freezing Target for 3 seconds","Cannot be Frozen","runeImg/r32_Cham.gif",67),
    ZOD("Zod","Indestructible","Indestructible","runeImg/r33_Zod.gif",69),;


    private final String name;
    private final int reqLvl;
    private final String propWeapon;
    private final String propArmor;
    private final String propShield;
    private final String imgDir;

    Rune(String name, String propWeapon, String propArmor, String imgDir, int reqLvl) {
        this.name = name;
        this.propWeapon = propWeapon;
        this.propArmor = propArmor;
        this.propShield = null;
        this.imgDir = imgDir;
        this.reqLvl = reqLvl;
    }

    Rune(String name, String propWeapon, String propArmor, String propShield, String imgDir, int reqLvl) {
        this.name = name;
        this.propWeapon = propWeapon;
        this.propArmor = propArmor;
        this.propShield = propShield;
        this.imgDir = imgDir;
        this.reqLvl = reqLvl;
    }

    public String getName() {
        return this.name;
    }

    public int getReqLvl() {
        return reqLvl;
    }

    public String getPropWeapon() {
        return propWeapon;
    }

    public String getPropArmor() {
        return propArmor;
    }

    public String getPropShield() {
        return propShield;
    }

    public String getImgDir() {
        return imgDir;
    }
}

