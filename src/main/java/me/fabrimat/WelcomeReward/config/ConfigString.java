package me.fabrimat.WelcomeReward.config;

import org.bukkit.ChatColor;

public class ConfigString {
	
	private String value;
	
	public ConfigString(String s) {
		this.value = s;
	}
	
	public String getRawValue() {
		return value;
	}
	
	public String getFormattedValue() {
		return ChatColor.translateAlternateColorCodes('&', Config.getInstance().getPrefix() + " " + value);
	}
	
	public String toString() {
		return value;
	}
	
}
