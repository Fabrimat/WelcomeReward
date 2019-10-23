package me.fabrimat.WelcomeReward.config;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import me.fabrimat.WelcomeReward.WelcomeReward;

public class Config {

	private static Config instance = null;
	private YamlConfiguration config = null;
	private WelcomeReward main = null;
	
	private List<String> commands;
	private String word;
	private Long timer;
	private String prefix;
	private String rewardMessage;
	private String configReloadMessage;
	private String noPermissionMessage;
	
	private Config() {
		this.main = WelcomeReward.getInstance();
		this.loadFile();
	}

	public static Config getInstance() {
		if(instance == null) {
			instance = new Config();
		}
		return instance;
	}
	
	public void loadFile() {
		this.main.saveConfig();
		this.main.reloadConfig();
		this.config = YamlConfiguration.loadConfiguration( new File(main.getDataFolder(), "config.yml"));
		this.commands = this.config.getStringList("commands");
		this.word = this.config.getString("word");
		this.timer = this.config.getLong("timer");
		this.prefix = this.config.getString("messages.prefix");
		this.rewardMessage = this.config.getString("messages.reward-message");
		this.configReloadMessage = this.config.getString("messages.config-reload");
		this.noPermissionMessage = this.config.getString("messages.no-permission");
	}
	
	public List<String> getCommands(){
		return this.commands;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public Long getTimer() {
		return this.timer;
	}
	
	public String getPrefix() {
		return this.prefix;
	}
	
	public ConfigString getRewardMessage() {
		return new ConfigString(this.rewardMessage);
	}
	
	public ConfigString getConfigReloadMessage() {
		return new ConfigString(this.configReloadMessage);
	}

	public ConfigString getNoPermissionMessage() {
		return new ConfigString(this.noPermissionMessage);
	}
}
