package me.fabrimat.WelcomeReward;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.fabrimat.WelcomeReward.config.Config;

public class RewardsManager {

	private static RewardsManager instance = null;
	
	private List<UUID> users = new ArrayList<UUID>();
	private Long lastJoined = Long.MAX_VALUE;
	
	private RewardsManager() {
		
	}
	
	public static RewardsManager getInstance() {
		if(instance == null) {
			instance = new RewardsManager();
		}
		return instance;
	}
	
	public void insertPlayer(UUID u) {
		users.add(u);
	}
	
	public Boolean getIfRewarded(UUID u) {
		return users.contains(u);
	}
	
	public void resetList() {
		users.clear();
	}
	
	public void setLastJoined(Long time) {
		this.lastJoined = time;
	}
	
	public Long getLastJoined() {
		return this.lastJoined;
	}
	
	public Boolean isRewardTime(Long time) {
		if(time - this.lastJoined < Config.getInstance().getTimer()*1000L)
			return true;
		return false;
	}
	
	
}
