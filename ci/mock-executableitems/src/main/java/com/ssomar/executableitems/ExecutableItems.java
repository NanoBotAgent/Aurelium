package com.ssomar.executableitems;

public class ExecutableItems {
    // Mock implementation for CI testing
    public static ExecutableItems getInstance() {
        return new ExecutableItems();
    }

    public ExecutableItemInterface getExecutableItem(String id) {
        return new MockExecutableItem(id);
    }
}
