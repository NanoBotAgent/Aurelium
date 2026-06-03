package mock;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MockItem {
    private final String id;
    private final ItemStack stack;

    public MockItem(String id, Material mat) {
        this.id = id;
        this.stack = new ItemStack(mat);
    }

    public String getId() {
        return id;
    }

    public ItemStack getStack() {
        return stack;
    }
}
