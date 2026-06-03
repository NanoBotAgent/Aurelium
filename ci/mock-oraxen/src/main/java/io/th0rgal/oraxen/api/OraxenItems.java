package io.th0rgal.oraxen.api;

import java.util.HashMap;
import java.util.Map;

public class OraxenItems {
    private static OraxenItems instance;
    private final Map<String, OraxenItem> items = new HashMap<>();

    public OraxenItems() {
        instance = this;
    }

    public static OraxenItems getInstance() {
        return instance;
    }

    public void registerItem(String id, OraxenItem item) {
        items.put(id.toLowerCase(), item);
    }

    public OraxenItem getItem(String id) {
        return items.get(id.toLowerCase());
    }

    public boolean hasItem(String key) {
        return items.containsKey(key.toLowerCase());
    }
}
