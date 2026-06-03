package net.indyuce.mmoitems.manager;

import net.indyuce.mmoitems.api.MMOItem;
import net.indyuce.mmoitems.api.Type;
import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    private final Map<String, MMOItem> items = new HashMap<>();

    public void register(MMOItem item) {
        items.put(item.getId().toLowerCase(), item);
    }

    public MMOItem getItem(String id) {
        return items.get(id.toLowerCase());
    }

    public boolean exists(String key) {
        return items.containsKey(key.toLowerCase());
    }
}
