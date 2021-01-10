package items;

public enum ItemType {

    AXE("Axes", 6, ItemTypeContainer.MELEE_WEAPON),
    BODY_ARMOR("Body Armors", 4),
    BOW("Bows", 6, ItemTypeContainer.MISSILE_WEAPON),
    CLAW("Claws", 3, ItemTypeContainer.MELEE_WEAPON),
    CLUB("Clubs", 3, ItemTypeContainer.MELEE_WEAPON),
    CROSSBOW("Crossbows", 6,ItemTypeContainer.MISSILE_WEAPON),
    HAMMER("Hammers", 6, ItemTypeContainer.MELEE_WEAPON),
    HELM("Helms", 3),
    MACE("Maces", 5, ItemTypeContainer.MELEE_WEAPON),
    ORB("Orbs", 3, ItemTypeContainer.WEAPON),
    PALA_SHIELD("Paladin Shields", 4, ItemTypeContainer.SHIELD),
    POLEARM("Polearms", 6, ItemTypeContainer.MELEE_WEAPON),
    SCEPTER("Scepters", 5, ItemTypeContainer.MELEE_WEAPON),
    SHIELD("Shields", 4, ItemTypeContainer.SHIELD),
    STAFF("Staffs", 6, ItemTypeContainer.MELEE_WEAPON),
    SWORD("Swords", 6, ItemTypeContainer.MELEE_WEAPON),
    WAND("Wands", 2, ItemTypeContainer.MELEE_WEAPON);

    private final int maxSocket;
    private final String name;

    ItemType(String name, int maxSocket) {
        this.maxSocket = maxSocket;
        this.name = name;
    }

    ItemType(String name, int maxSocket, final ItemTypeContainer container) {
        this(name, maxSocket);
        container.addType(this);
    }

    public int getMaxSocket() {
        return maxSocket;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }

}
