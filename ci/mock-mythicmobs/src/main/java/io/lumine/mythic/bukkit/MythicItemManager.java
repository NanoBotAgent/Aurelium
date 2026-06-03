package io.lumine.mythic.bukkit;

import java.util.HashMap;
import java.util.Map;

public class MythicItemManager {
    private final Map<String, Object> items = new HashMap<>();

    public void registerItem(String id, Object item) {
        items.put(id.toLowerCase(), item);
    }

    public Object getItem(String key) {
        return items.get(key.toLowerCase());
    }

    public boolean hasItem(String key) {
        return items.containsKey(key.toLowerCase());
    }
}
