package me.fabrimat.WelcomeReward.listeners;

import java.util.Date;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.fabrimat.WelcomeReward.RewardsManager;

public class PlayerFirstJoinListener  implements Listener{
	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore() || true) {
			RewardsManager manager = RewardsManager.getInstance();
			manager.insertPlayer(p.getUniqueId());
			manager.setLastJoined(new Date().getTime());
			manager.resetList();
		}
	}
}
