package mock;

import java.util.HashMap;
import java.util.Map;

public class MockStressItemsAdder {
    private static MockStressItemsAdder instance;
    private final Map<String, Object> items = new HashMap<>();

    public MockStressItemsAdder() {
        instance = this;
    }

    public static MockStressItemsAdder getInstance() {
        return instance;
    }

    public void registerItem(String id, Object item) {
        items.put(id.toLowerCase(), item);
    }

    public Object getItem(String key) {
        return items.get(key.toLowerCase());
    }
}
