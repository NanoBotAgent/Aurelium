package mock;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class MockEIItem {
    private final String id;
    private final ItemStack item;

    public MockEIItem(String id, Material material, int amount) {
        this.id = id;
        this.item = new ItemStack(material, amount);
    }

    public String getId() {
        return id;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getAmount() {
        return item.getAmount();
    }
}
