package me.awesomeman2812.BlockRunner.objects;

import java.util.List;

import me.awesomeman2812.BlockRunner.enums.ArenaState;

import org.bukkit.Location;

public class Arena {

	private String name;
	private String gamemode;
	private Location lobby, spawn;
	private List<Location> levels;
	private ArenaState state;
	private int arenatime;
	private int lobbytime;
	
	public Arena(String nm, String gm, Location lob, Location sp, List<Location> lvl, ArenaState st, int at, int lt){
		gamemode = gm;
		name = nm;
	    lobby = lob;
	    spawn = sp;
	    levels = lvl;
	    state = st;
	    arenatime = at;
	    lobbytime = lt;
	}
	
	//Setter methods
	public void setArenaName(String n){
		name = n;
	}
	
	public void setGamemode(String gm){
		gamemode = gm;
	}
	
	public void setLobbyLocation(Location l){
		lobby = l;
	}
	
	public void setArenaSpawnLocation(Location l){
		spawn = l;
	}
	
	public void setLevelLocations(List<Location> lvls){
		levels = lvls;
	}
	
	public void setArenaState(ArenaState as){
		state = as;
	}
	
	public void setArenaTime(int at){
		arenatime = at;
	}
	
	public void setLobbyTime(int lt){
		lobbytime = lt;
	}
	
	//Getter methods
	public String getArenaName(){
		return name;
	}
	
	public String getGamemode(){
		return gamemode;
	}
	
	public Location getLobbyLocation(){
		return lobby;
	}
	
	public Location getArenaSpawnLocation(){
		return spawn;
	}
	
	public List<Location> getLevelLocations(){
		return levels;
	}
	
	public ArenaState getArenaState(){
		return state;
	}
	
	public int getArenaTime(){
		return arenatime;
	}
	
	public int getLobbyTime(){
		return lobbytime;
	}
}
