package me.awesomeman2812.BlockRunner.commands;

import me.awesomeman2812.BlockRunner.enums.ArenaState;
import me.awesomeman2812.BlockRunner.main.BR;
import me.awesomeman2812.BlockRunner.managers.ArenaManager;
import me.awesomeman2812.BlockRunner.objects.Arena;

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
								Arena a = new Arena(args[2], args[3], null, null, null, ArenaState.Disabled, 18000, 30);
								BR.getArenaManager().addArena(a);
								p.sendMessage(starter() + "Arena " + args[2] + " successfully created under the gamemode of " + args[3] + "!");
							}else{
								p.sendMessage(starter() + "Please insert a valid gamemode! Valid gamemodes: solo, 1vs1");
							}
						}else{
							p.sendMessage(starter() + "Please include an arena name and gamemode! /br arena create [ArenaName] [Gamemode]");
						}
					}else if(args[1].equalsIgnoreCase("list")){
						p.sendMessage(starter() + "Current Registered Arenas:");
						for(Arena a : BR.getArenaManager().getArenas()){
							p.sendMessage(starter() + a.getArenaName() + " - Gamemode: " + a.getGamemode() + " State: " + a.getArenaState());
						}
					}else if(args[1].equalsIgnoreCase("set")){
						if(args[2].equalsIgnoreCase("lobbytime")){
							if(!args[3].isEmpty() && !args[4].isEmpty()){
								int temp = Integer.parseInt(args[4]);
								BR.getArenaManager().getArena(args[3]).setLobbyTime(temp);
								p.sendMessage(starter() + "Successfully set lobbytime of " + BR.getArenaManager().getArena(args[3]).getArenaName() 
										+ " to " + BR.getArenaManager().getArena(args[3]).getLobbyTime() + "!");
							}
						}else if(args[2].equalsIgnoreCase("arenatime")){
							if(!args[3].isEmpty() && !args[4].isEmpty()){
								int temp2 = Integer.parseInt(args[4]);
								BR.getArenaManager().getArena(args[3]).setArenaTime(temp2);
								p.sendMessage(starter() + "Successfully set arenatime of " + BR.getArenaManager().getArena(args[3]).getArenaName() 
										+ " to " + BR.getArenaManager().getArena(args[3]).getArenaTime() + "!");
							}
						}else if(args[2].equalsIgnoreCase("lobbyspawn")){
							if(!args[3].isEmpty()){
								BR.getArenaManager().getArena(args[3]).setLobbyLocation(p.getLocation());
								p.sendMessage(starter() + "Successfully set lobbylocation of " + BR.getArenaManager().getArena(args[3]).getArenaName() + " to your position!");
							}
						}else if(args[2].equalsIgnoreCase("arenaspawn")){
							if(!args[3].isEmpty()){
								BR.getArenaManager().getArena(args[3]).setArenaSpawnLocation(p.getLocation());
								p.sendMessage(starter() + "Successfully set arenaspawn of " + BR.getArenaManager().getArena(args[3]).getArenaName() + " to your position!");
							}
						}
					}else if(args[1].equalsIgnoreCase("addlvlspawn")){
						if(!args[2].isEmpty() && !args[3].isEmpty()){
							int temp3 = Integer.parseInt(args[3]);
							BR.getArenaManager().getArena(args[2]).addLevelLocation(p.getLocation(), temp3);
							p.sendMessage(starter() + "Successfully added level " + temp3 + " spawn to arena " + BR.getArenaManager().getArena(args[2]).getArenaName() + "!");
						}
					}
				}else{
					p.sendMessage(starter() + "You don't have permission to use this command!");
				}
			
			}else if(args[0].equalsIgnoreCase("enable")){
				if(p.hasPermission("blockrunner.mod")){
					if(!args[1].isEmpty()){
						BR.getArenaManager().getArena(args[1]).setArenaState(ArenaState.Lobby);
						p.sendMessage(starter() + "Successfully enabled " + BR.getArenaManager().getArena(args[1]).getArenaName() + "!");
					}
				}
			}else if(args[0].equalsIgnoreCase("disable")){
				if(p.hasPermission("blockrunner.mod")){
					if(!args[1].isEmpty()){
						BR.getArenaManager().getArena(args[1]).setArenaState(ArenaState.Disabled);
						p.sendMessage(starter() + "Successfully disabled " + BR.getArenaManager().getArena(args[1]).getArenaName() + "!");
					}
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
			pl.sendMessage(ChatColor.AQUA + "/br arena set [Setting] [ArenaName] (Value) -");
			pl.sendMessage(ChatColor.AQUA + "Changes a certain setting of a certain arena!");
			pl.sendMessage(ChatColor.AQUA + "/br arena addlvlspawn [ArenaName] [Level#] -");
			pl.sendMessage(ChatColor.AQUA + "Adds a level to an arena (and its spawn)");
			pl.sendMessage(ChatColor.AQUA + "/br arena list - Lists all created arenas");
			pl.sendMessage(ChatColor.GREEN + "--------------------------------");
		}else if(pl.hasPermission("blockrunner.mod")){
			pl.sendMessage(ChatColor.DARK_GREEN+ "You are a Moderator! Here are your special");
			pl.sendMessage(ChatColor.DARK_GREEN + "commands! You also gain the commands and");
			pl.sendMessage(ChatColor.DARK_GREEN + "perks of ranks that are lower than you!");
			pl.sendMessage(ChatColor.AQUA + "/br enable [ArenaName] - Enables an Arena.");
			pl.sendMessage(ChatColor.AQUA + "/br disable [ArenaName] - Disables an Arena.");
			pl.sendMessage(ChatColor.AQUA + "Creates an arena under a name and gamemode");
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
