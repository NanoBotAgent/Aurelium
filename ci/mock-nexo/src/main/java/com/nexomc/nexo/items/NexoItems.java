package com.nexomc.nexo.items;

import java.util.HashMap;
import java.util.Map;

public class NexoItems {
    private static NexoItems instance;
    private final Map<String, NexoItem> items = new HashMap<>();

    public NexoItems() {
        instance = this;
    }

    public static NexoItems getInstance() {
        return instance;
    }

    public NexoItem getItem(String id) {
        return items.get(id.toLowerCase());
    }

    public void registerItem(NexoItem item) {
        items.put(item.getId().toLowerCase(), item);
    }
}
