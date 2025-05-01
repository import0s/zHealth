package org.import_os.zHealth;

import org.bukkit.plugin.java.JavaPlugin;

public final class ZHealth extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("zHealth Enalbled v1.0");

    }

    @Override
    public void onDisable() {
        getLogger().info("zHealth Disabled");
    }
}
