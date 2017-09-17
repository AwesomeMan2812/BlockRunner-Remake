package me.awesomeman2812.BlockRunner.main;

import me.awesomeman2812.BlockRunner.commands.CommandHandler;
import me.awesomeman2812.BlockRunner.listeners.SignListener;
import me.awesomeman2812.BlockRunner.managers.ArenaManager;
import me.awesomeman2812.BlockRunner.managers.QueueManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BR extends JavaPlugin{
	private static BR plugin;
	public static ArenaManager ar;
	public static QueueManager qr;
	
	@Override
	public void onEnable(){
		plugin = this;
		System.out.println("[BlockRunner-Remake] BlockRunner v2.0 (Version " + plugin.getDescription().getVersion() + ") has been enabled!");
		getCommand("br").setExecutor(new CommandHandler());
		Bukkit.getPluginManager().registerEvents(new SignListener(), this);
		ar = new ArenaManager();
		qr = new QueueManager();
	}
	
	@Override
	public void onDisable(){
		System.out.println("[BlockRunner-Remake] BlockRunner v2.0 (Version " + plugin.getDescription().getVersion() + ") has been disabled!");
	}
	
	public static ArenaManager getArenaManager(){
		return ar;
	}
	
	public static QueueManager getQueueManager(){
		return qr;
	}
}
