package net.indyuce.mmoitems;

import net.indyuce.mmoitems.api.Type;
import net.indyuce.mmoitems.manager.ItemManager;
import java.util.HashMap;
import java.util.Map;

public class MMOItems {
    private static MMOItems instance;
    private final ItemManager itemManager;
    private final Map<String, Object> items = new HashMap<>();

    public MMOItems(ItemManager itemManager) {
        this.itemManager = itemManager;
        instance = this;
    }

    public static MMOItems getInstance() {
        return instance;
    }

    public ItemManager getItems() {
        return itemManager;
    }

    public Object getItem(String id) {
        return items.get(id.toLowerCase());
    }

    public boolean hasItem(String key) {
        return items.containsKey(key.toLowerCase());
    }
}
