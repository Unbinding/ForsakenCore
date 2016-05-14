package ga.unbinding.forsakencore.cmds;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class VanishCommand implements CommandExecutor {

	public static ArrayList<Player> vanished = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can this command!");
			return true;
		}
		
		Player p = (Player)sender;
		
		if(!sender.hasPermission("staff.vanish")){
			MM.message(sender, MessageType.Recruit);
			return true;
		}
		VanishCommand.vanish(p);
		return true;
	}
	public static void vanish(Player p){
		if(!vanished.contains(p)){
			for(Player pl : Bukkit.getServer().getOnlinePlayers()){
				if(!pl.hasPermission("staff.vanish.see")){
					pl.hidePlayer(p);
				}
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 10));
			p.sendMessage("§9Vanish> §7You're now vanished from all normal players. To unvanish, simply do /vanish again.");
			vanished.add(p);
		}else{
			for(Player pl : Bukkit.getServer().getOnlinePlayers()){
				pl.showPlayer(p);
			}
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			p.sendMessage("§9Vanish> §7You're now revealed to all normal players. To revanish, simply do /vanish again.");
			vanished.remove(p);
		}
	}

}
