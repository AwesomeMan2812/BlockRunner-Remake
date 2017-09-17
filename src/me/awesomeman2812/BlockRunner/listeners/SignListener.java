package me.awesomeman2812.BlockRunner.listeners;

import me.awesomeman2812.BlockRunner.main.BR;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignListener implements Listener{
	
	private String brprefix = ChatColor.GREEN + "[BlockRunner]";
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		if(e.getLine(0).equalsIgnoreCase("[blockrunner]")){
            if(e.getLine(1).equalsIgnoreCase("solo")){
                e.setLine(0, brprefix);
                e.setLine(1, ChatColor.DARK_RED+"SOLO");
                e.setLine(2, ChatColor.AQUA+"Right-Click to");
                e.setLine(3, ChatColor.AQUA+"join the Queue!");
            }
            else if(e.getLine(1).equalsIgnoreCase("leave")){
                e.setLine(0, brprefix);
                e.setLine(1, "Right-Click");
                e.setLine(2, "To Leave!");
            }
            else if(e.getLine(1).equalsIgnoreCase("1vs1")){
                e.setLine(0, brprefix);
                e.setLine(1, ChatColor.DARK_RED+"1VS1");
                e.setLine(2, ChatColor.AQUA+"Right-Click to");
                e.setLine(3, ChatColor.AQUA+"join the Queue!");
            }
        }
	}
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e){
		Player p = e.getPlayer();      
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
        	if (e.getClickedBlock().getState() instanceof Sign) {
        		Sign s = (Sign) e.getClickedBlock().getState(); 
                if(s.getLine(1).equals(ChatColor.DARK_RED+"SOLO")){
                	BR.getQueueManager().addPlayer(p, "solo");
                }else if(s.getLine(1).equals(ChatColor.DARK_RED+"1VS1")){
                	BR.getQueueManager().addPlayer(p, "1vs1");
                }else if(s.getLine(2).equalsIgnoreCase("To Leave!")){
                	//Leave code
                	p.sendMessage(brprefix + " " + ChatColor.AQUA + "You have successfully left the arena!");
                }
            }
        }
	}

}
