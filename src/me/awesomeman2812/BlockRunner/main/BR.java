package me.awesomeman2812.BlockRunner.main;

import me.awesomeman2812.BlockRunner.commands.CommandHandler;

import org.bukkit.plugin.java.JavaPlugin;

public class BR extends JavaPlugin{
	private static BR plugin;
	
	@Override
	public void onEnable(){
		plugin = this;
		System.out.println("[BlockRunner] BlockRunner v2.0 (Version " + plugin.getDescription().getVersion() + ") has been enabled!");
		getCommand("br").setExecutor(new CommandHandler());
	}
	
	@Override
	public void onDisable(){
		System.out.println("[BlockRunner] BlockRunner v2.0 (Version " + plugin.getDescription().getVersion() + ") has been disabled!");
	}	
}
