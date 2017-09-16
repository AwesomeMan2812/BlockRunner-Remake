package me.awesomeman2812.BlockRunner.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sun.net.ftp.FtpDirEntry.Permission;

public class CommandHandler implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("blockrunner")){
			if(args.length == 0){
				p.sendMessage(starter() + "BlockRunner v2.0 made for BTCraft by AwesomeMan2812 (eXish)."); 
				p.sendMessage(starter() + "This is the main BlockRunner command, for a list of commands type /br help!"); 
			}else if(args[0].equalsIgnoreCase("help")){
				help(p);
			}
			return true;
		}
		return false;
	}
	
	public void help(Player pl){
		pl.sendMessage(ChatColor.GREEN + "    --BTCraft BlockRunner v2.0--");
		pl.sendMessage(ChatColor.GREEN + "------------------------------------");
		pl.sendMessage(ChatColor.AQUA + "/br - Main command");
		pl.sendMessage(ChatColor.AQUA + "/br help - Brings up this help menu!");
		pl.sendMessage(ChatColor.GREEN + "------------------------------------");
		pl.sendMessage(ChatColor.GREEN + "     --Rank Specific Commands--");
		pl.sendMessage(ChatColor.GREEN + "------------------------------------");
		if(pl.hasPermission("blockrunner.vip")){
			pl.sendMessage(ChatColor.AQUA + "You are a VIP! There are no specific");
			pl.sendMessage(ChatColor.AQUA + "commands for this rank, but there is");
			pl.sendMessage(ChatColor.AQUA + "a couple of perks!");
			pl.sendMessage(ChatColor.GREEN + "------------------------------------");
			pl.sendMessage(ChatColor.AQUA + "(perks will go here when made)");
		}else{
			pl.sendMessage(ChatColor.AQUA + "You are a default player! You have");
			pl.sendMessage(ChatColor.AQUA + "no special commands!");
		}
	}
	
	private String starter(){
		return ChatColor.GREEN + "[BlockRunner] " + ChatColor.AQUA;
	}
}
