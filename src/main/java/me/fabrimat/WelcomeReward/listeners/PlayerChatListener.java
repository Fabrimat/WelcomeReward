package me.fabrimat.WelcomeReward.listeners;

import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.fabrimat.WelcomeReward.RewardsManager;
import me.fabrimat.WelcomeReward.WelcomeReward;
import me.fabrimat.WelcomeReward.config.Config;

public class PlayerChatListener implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Config config = Config.getInstance();
		
		if(e.getMessage().toLowerCase().contains(config.getWord().toLowerCase())) {
			Player p = e.getPlayer();
			if(!p.hasPermission("welcomereward.getreward")) {
				return;
			}
			RewardsManager manager = RewardsManager.getInstance();
			if(manager.isRewardTime(new Date().getTime()) && !manager.getIfRewarded(p.getUniqueId())) {
				manager.insertPlayer(p.getUniqueId());
				for(String command : config.getCommands()) {
        			command = command.replace("[playerName]", p.getName());
        			
        			class CommandDispatcher implements Runnable {
        				
        				private String command;
        				
        				CommandDispatcher(String cmd){
        					this.command = cmd;
        				}
        				
						public void run() {
							Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
						}
        			}
    				WelcomeReward.getInstance().getServer().getScheduler().runTask(WelcomeReward.getInstance(), new CommandDispatcher(command));
        		}
    			p.sendMessage(config.getRewardMessage().getFormattedValue());
			}
		}
	}
}
