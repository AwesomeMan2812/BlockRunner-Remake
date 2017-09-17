package me.awesomeman2812.BlockRunner.managers;

import java.util.ArrayList;

import me.awesomeman2812.BlockRunner.objects.Arena;

public class ArenaManager {

	private ArrayList<Arena> brArenas;
	
	public ArenaManager(){
		this.brArenas = new ArrayList<Arena>();
	}
	
	public Arena getArena(String n){
		for(Arena a : brArenas){
			if(a.getArenaName().equalsIgnoreCase(n)){
				return a;
			}
		}
		return null;
	}
	
	public void addArena(Arena a){
		brArenas.add(a);
	}
	
	public ArrayList<Arena> getArenas(){
		return brArenas;
	}
}
