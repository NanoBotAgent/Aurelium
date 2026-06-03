package net.indyuce.mmoitems.api;

public class MMOItem {
    private final String id;
    private final Type type;

    public MMOItem(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }
}
