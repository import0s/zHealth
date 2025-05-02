package org.import_os.zHealth;

import org.bukkit.plugin.java.JavaPlugin;

public final class ZHealth extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        long start = System.nanoTime();
        getLogger().info("zHealth Enabled v1.0");
        getLogger().info("For any problem open an issue on GitHub");
        getCommand("sethealth").setExecutor(new setHealth());
        getCommand("sethunger").setExecutor(new setHunger());
        getCommand("health").setExecutor(new ShowHealth());
        getCommand("hunger").setExecutor(new ShowHunger());

        long end = System.nanoTime();
        getLogger().info("Plugin enabled in " + ((end - start) / 1_000_000) + "ms");

    }

    @Override
    public void onDisable() {
        long start = System.nanoTime();
        getLogger().info("zHealth Disabled");
        long end = System.nanoTime();
        getLogger().info("Plugin disabled in " + ((end - start) / 1_000_000) + "ms");
    }
}
