package me.fabrimat.WelcomeReward.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.fabrimat.WelcomeReward.config.Config;

public class WelcomeRewardCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length < 1) {
			return false;
		}

		if(!sender.hasPermission("welcomereward.admin")) {
			sender.sendMessage(Config.getInstance().getNoPermissionMessage().getFormattedValue());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("reload")) {
			Config config = Config.getInstance();
			config.loadFile();
			sender.sendMessage(config.getConfigReloadMessage().getFormattedValue());
		}
		
		return true;
	}
	
}
