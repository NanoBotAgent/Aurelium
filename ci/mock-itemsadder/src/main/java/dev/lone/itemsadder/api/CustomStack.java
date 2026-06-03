package dev.lone.itemsadder.api;

public class CustomStack {
    private final String id;
    private final String namespacedId;

    public CustomStack(String id) {
        this.id = id;
        this.namespacedId = id;
    }

    public String getNamespacedId() {
        return namespacedId;
    }

    public boolean isSimilar(CustomStack other) {
        return other != null && this.namespacedId.equals(other.namespacedId);
    }
}
