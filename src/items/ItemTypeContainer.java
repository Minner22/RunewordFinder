package items;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum ItemTypeContainer {

    SHIELD,
    WEAPON,
    MELEE_WEAPON(WEAPON),
    MISSILE_WEAPON(WEAPON);

    private final ItemTypeContainer parent;
    private final Set<ItemType> types = new HashSet<>();

    ItemTypeContainer() {
        parent = null;
    }

    ItemTypeContainer(ItemTypeContainer parent) {
        this.parent = parent;
    }

    void addType(final ItemType itemType) {
        if (types.add(itemType) && parent != null) {
            parent.addType(itemType);
        }
    }


    public Set<ItemType> getTypes() {
        return Collections.unmodifiableSet(types);
    }
}
