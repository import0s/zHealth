package org.import_os.zHealth;

import org.bukkit.plugin.java.JavaPlugin;

public final class ZHealth extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("zHealth Enabled v1.0");
        getCommand("sethealth").setExecutor(new setHealth());
        getCommand("sethunger").setExecutor(new setHunger());
        getCommand("showhealth").setExecutor(new ShowHealth());
        getCommand("showhunger").setExecutor(new ShowHunger());

    }

    @Override
    public void onDisable() {
        getLogger().info("zHealth Disabled");
    }
}
