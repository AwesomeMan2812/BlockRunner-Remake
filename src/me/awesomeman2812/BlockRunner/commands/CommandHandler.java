package me.awesomeman2812.BlockRunner.commands;

import me.awesomeman2812.BlockRunner.enums.ArenaState;
import me.awesomeman2812.BlockRunner.managers.ArenaManager;
import me.awesomeman2812.BlockRunner.objects.Arena;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sun.net.ftp.FtpDirEntry.Permission;

public class CommandHandler implements CommandExecutor{

	public ArenaManager ar;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("br")){
			if(args.length == 0){
				p.sendMessage(starter() + "BlockRunner v2.0 made for BTCraft by AwesomeMan2812 (eXish)."); 
				p.sendMessage(starter() + "This is the main BlockRunner command, for a list of commands type /br help!"); 
			}else if(args[0].equalsIgnoreCase("help")){
				help(p);
			}else if(args[0].equalsIgnoreCase("arena")){
				if(p.hasPermission("blockrunner.admin")){
					if(args[1].equalsIgnoreCase("create")){
						if(!args[2].isEmpty()){
							if(args[3].equalsIgnoreCase("solo") || args[3].equalsIgnoreCase("1vs1")){
								Arena a = new Arena(args[2], args[3], null, null, null, ArenaState.Disabled, 0, 0);
								ar.addArena(a);
								p.sendMessage("Arena " + args[2] + " successfully created under the gamemode of " + args[3] + "!");
							}else{
								p.sendMessage(starter() + "Please insert a valid gamemode! Valid gamemodes: solo, 1vs1");
							}
						}else{
							p.sendMessage(starter() + "Please include an arena name and gamemode! /br arena create [ArenaName] [Gamemode]");
						}
					}else if(args[1].equalsIgnoreCase("list")){
						p.sendMessage(starter() + "Current Registered Arenas:");
						for(Arena a : ar.getArenas()){
							p.sendMessage(starter() + a.getArenaName() + " - Gamemode: " + a.getGamemode() + " State: " + a.getArenaState());
						}
					}
				}else{
					p.sendMessage(starter() + "You don't have permission to use this command!");
				}
			}
			return true;
		}
		return false;
	}
	
	public void help(Player pl){
		pl.sendMessage(ChatColor.GREEN + "    --BTCraft BlockRunner v2.0--");
		pl.sendMessage(ChatColor.GREEN + "--------------------------------");
		pl.sendMessage(ChatColor.AQUA + "/br - Main command");
		pl.sendMessage(ChatColor.AQUA + "/br help - Brings up this help menu");
		pl.sendMessage(ChatColor.GREEN + "--------------------------------");
		pl.sendMessage(ChatColor.GREEN + "     --Rank Specific Commands--");
		pl.sendMessage(ChatColor.GREEN + "--------------------------------");
		if(pl.hasPermission("blockrunner.admin")){
			pl.sendMessage(ChatColor.DARK_GREEN+ "You are an Admin! Here are your special");
			pl.sendMessage(ChatColor.DARK_GREEN + "commands! You also gain the commands and");
			pl.sendMessage(ChatColor.DARK_GREEN + "perks of ranks that are lower than you!");
			pl.sendMessage(ChatColor.AQUA + "/br arena create [ArenaName] [Gamemode] -");
			pl.sendMessage(ChatColor.AQUA + "Creates an arena under a name and gamemode");
			pl.sendMessage(ChatColor.AQUA + "/br arena list - Lists all created arenas");
			pl.sendMessage(ChatColor.GREEN + "--------------------------------");
		}else if(pl.hasPermission("blockrunner.vip")){
			pl.sendMessage(ChatColor.DARK_GREEN + "You are a VIP! There are no specific");
			pl.sendMessage(ChatColor.DARK_GREEN + "commands for this rank, but there is");
			pl.sendMessage(ChatColor.DARK_GREEN + "a couple of perks!");
			pl.sendMessage(ChatColor.GREEN + "--------------------------------");
			pl.sendMessage(ChatColor.AQUA + "(perks will go here when made)");
		}else{
			pl.sendMessage(ChatColor.DARK_GREEN + "You are a default player! You have");
			pl.sendMessage(ChatColor.DARK_GREEN+ "no special commands!");
		}
	}
	
	private String starter(){
		return ChatColor.GREEN + "[BlockRunner] " + ChatColor.AQUA;
	}
}
