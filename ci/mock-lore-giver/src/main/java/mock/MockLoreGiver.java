package mock;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MockLoreGiver {
    public static ItemStack addLore(ItemStack item, String lore) {
        org.bukkit.inventory.meta.ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            java.util.List<String> lores = meta.getLore() != null ? meta.getLore() : new java.util.ArrayList<>();
            lores.add(lore);
            meta.setLore(lores);
            item.setItemMeta(meta);
        }
        return item;
    }
}
