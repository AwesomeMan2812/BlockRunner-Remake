package me.awesomeman2812.BlockRunner.managers;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;

import me.awesomeman2812.BlockRunner.enums.ArenaState;
import me.awesomeman2812.BlockRunner.main.BR;
import me.awesomeman2812.BlockRunner.objects.Arena;
import me.awesomeman2812.BlockRunner.objects.Queue;

public class QueueManager {

	private BR plugin;
	private Queue solo, duel;
	
	public QueueManager(){
		this.solo = new Queue("solo");
		this.duel = new Queue("1vs1");
	}
	
	public void addPlayer(Player p, String gm){
		ArrayList<Arena> enabledArenassolo = new ArrayList<Arena>();
		ArrayList<Arena> enabledArenasduel = new ArrayList<Arena>();
		for(Arena a : BR.getArenaManager().getArenas()){
			if(!(a.getArenaState() == ArenaState.Disabled)){
				if(a.getGamemode() == gm && gm == "solo"){
					enabledArenassolo.add(a);
				}else if(a.getGamemode() == gm && gm == "1vs1"){
					enabledArenasduel.add(a);
				}
			}
		}
		if(gm == "solo" && !enabledArenassolo.isEmpty()){
			for(Arena a : enabledArenassolo){
				if(a.getArenaState() == ArenaState.Lobby){
					p.teleport(a.getLobbyLocation());
					return;
				}
			}
			solo.addPlayertoQueue(p);
			p.sendMessage(ChatColor.GREEN + "[BlockRunner] " + ChatColor.AQUA + "No available arena was found! Added to the queue for solo!");
			checkArenas(enabledArenassolo, p);
		}else if(gm == "1vs1" && !enabledArenasduel.isEmpty()){
			for(Arena a : enabledArenasduel){
				if(a.getArenaState() == ArenaState.Lobby){
					p.teleport(a.getLobbyLocation());
					return;
				}
			}
			duel.addPlayertoQueue(p);
			p.sendMessage(ChatColor.GREEN + "[BlockRunner] " + ChatColor.AQUA + "No available arena was found! Added to the queue for 1vs1!");
			checkArenas(enabledArenasduel, p);
		}else{
			p.sendMessage(ChatColor.GREEN + "[BlockRunner] " + ChatColor.BLUE + "There are currently no enabled arenas for this gamemode!"
		        + " Try again later or try another gamemode!");
		}
	}
	
	public void checkArenas(ArrayList<Arena> a, Player p){
		do{
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
        	{
            	public void run()
            	{
            		for(Arena ar : a){
        				if(ar.getArenaState() == ArenaState.Lobby){
        					solo.removePlayerfromQueue(p);
        					p.sendMessage(ChatColor.GREEN + "[BlockRunner] " + ChatColor.BLUE + "Arena found! Joining arena " + ar.getArenaName() + "...");
        					p.teleport(ar.getLobbyLocation());
        					return;
        				}
        			}
            	} 
            },100);
		}while(solo.isPlayerinQueue(p));
	}
}
