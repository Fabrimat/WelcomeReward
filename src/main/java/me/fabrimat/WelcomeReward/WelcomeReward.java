package me.fabrimat.WelcomeReward;

import org.bukkit.plugin.java.JavaPlugin;

import me.fabrimat.WelcomeReward.config.Config;
import me.fabrimat.WelcomeReward.listeners.PlayerChatListener;
import me.fabrimat.WelcomeReward.listeners.PlayerFirstJoinListener;

public class WelcomeReward extends JavaPlugin{
	
	private static WelcomeReward instance  = null;
	
	@Override
	public void onEnable() {
		
		WelcomeReward.instance = this;
		
		this.saveDefaultConfig();
		Config.getInstance();
		
		getServer().getPluginManager().registerEvents(new PlayerFirstJoinListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static WelcomeReward getInstance() {
		return instance;
	}
	
}
