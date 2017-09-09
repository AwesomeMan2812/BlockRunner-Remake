package me.awesomeman2812.BlockRunner.main;

import org.bukkit.plugin.java.JavaPlugin;

public class BR extends JavaPlugin{
	private static BR plugin;
	
	@Override
	public void onEnable(){
		plugin = this;
	}
	
	@Override
	public void onDisable(){
		
	}
}
