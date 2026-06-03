package com.nexomc.nexo.items;

public class NexoItem {
    private final String id;
    private final String category;

    public NexoItem(String id, String category) {
        this.id = id;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}
