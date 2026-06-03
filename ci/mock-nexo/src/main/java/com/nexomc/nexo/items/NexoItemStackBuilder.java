package com.nexomc.nexo.items;

public class NexoItemStackBuilder {
    private final NexoItem item;

    public NexoItemStackBuilder(NexoItem item) {
        this.item = item;
    }

    public NexoItemStackBuilder amount(int amount) {
        return this;
    }

    public org.bukkit.inventory.ItemStack build() {
        return new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND);
    }
}
