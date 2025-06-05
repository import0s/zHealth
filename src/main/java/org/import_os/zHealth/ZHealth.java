package org.import_os.zHealth;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public final class ZHealth extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        String currentVer =  getDescription().getVersion();
        String versionURL = "https://raw.githubusercontent.com/import0s/zHealth/master/src/main/resources/version.txt";

        try {
            BufferedReader reader =  new BufferedReader(new InputStreamReader(new URL(versionURL).openStream()));
            String gitVer = reader.readLine().trim();
            reader.close();
            if (!gitVer.equals(currentVer)) {
                getLogger().warning("The plugin is OUTDATED! Download the latest version on GitHub");
            }
        } catch (Exception e) {
            getLogger().severe("An error has occurred during the Update check: " + e.getMessage());
        }

        long start = System.nanoTime();
        getLogger().info("zHealth Enabled v" + getDescription().getVersion());
        getLogger().info("For any problem open an issue on GitHub");
        getCommand("sethealth").setExecutor(new setHealth());
        getCommand("sethunger").setExecutor(new setHunger());
        getCommand("health").setExecutor(new ShowHealth());
        getCommand("hunger").setExecutor(new ShowHunger());
        getCommand("sethearts").setExecutor(new setHearts());

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
