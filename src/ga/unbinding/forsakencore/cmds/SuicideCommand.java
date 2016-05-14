package ga.unbinding.forsakencore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class SuicideCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can run this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(!sender.hasPermission("admin.suicide")){
			MM.message(sender, MessageType.Admin);
			return true;
		}
		
		p.setHealth(0);
		Bukkit.getServer().broadcastMessage("§9Suicide> §7" + p.getName() + " has decided to commit suicide...");
		
		
		return true;
	}

}
