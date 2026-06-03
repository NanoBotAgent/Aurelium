package io.lumine.mythic.bukkit;

public class MythicBukkit {
    private static MythicBukkit instance;

    public static MythicBukkit inst() {
        if (instance == null) {
            instance = new MythicBukkit();
        }
        return instance;
    }

    public MythicItemManager getItemManager() {
        return new MythicItemManager();
    }
}
