package com.sucy.sxitem;

import java.util.HashMap;
import java.util.Map;

public class SXItemManager {
    private final Map<String, SXItem> items = new HashMap<>();

    public void register(SXItem item) {
        items.put(item.getId(), item);
    }

    public SXItem getItem(String id) {
        return items.get(id);
    }
}
