package me.awesomeman2812.BlockRunner.objects;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Queue {

	private ArrayList<Player> players;
	private String gamemode;
	
	public Queue(String gm){
		players = new ArrayList<Player>();
		gamemode = gm;
	}
	
	public void addPlayertoQueue(Player p){
		players.add(p);
	}
	
	public void removePlayerfromQueue(Player p){
		int count = 0;
		for(Player pls : players){
			if(pls.getUniqueId() == p.getUniqueId()){
				players.remove(count);
			}
			count++;
		}
	}
	
	public boolean isPlayerinQueue(Player p){
		boolean found = false;
		for(Player pls : players){
			if(pls.getUniqueId() == p.getUniqueId()){
				found = true;
			}
		}
		return found;
	}
	
	public ArrayList<Player> getPlayersinQueue(){
		return players;
	}
	
	public void setGamemode(String gm){
		gamemode = gm;
	}
	
	public String getGamemode(String gm){
		return gamemode;
	}
}
