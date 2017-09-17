package me.awesomeman2812.BlockRunner.managers;

import java.util.List;

import me.awesomeman2812.BlockRunner.objects.Arena;

public class ArenaManager {

	private List<Arena> brArenas;
	
	public void addArena(Arena a){
		brArenas.add(a);
	}
	
	public Arena getArena(String n){
		for(Arena a : brArenas){
			if(a.getArenaName().equalsIgnoreCase(n)){
				return a;
			}
		}
		return null;
	}
	
	public List<Arena> getArenas(){
		return brArenas;
	}
}
