package com.nullshii.bullshit;

import com.nullshii.bullshit.Listeners.GiveRandomBullShitToPlayer;
import com.nullshii.bullshit.Listeners.LevitatePlayer;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class BullShit extends JavaPlugin {

    @Override
    public void onEnable() {
        registerListeners();
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new LevitatePlayer(), this);
        getServer().getPluginManager().registerEvents(new GiveRandomBullShitToPlayer(), this);
    }
}
