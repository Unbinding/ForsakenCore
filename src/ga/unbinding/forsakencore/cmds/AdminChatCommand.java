package ga.unbinding.forsakencore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class AdminChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		
		if(args.length == 0){
			sender.sendMessage("§9Admin Chat> §7/a <message>");
			return true;
		}
		
		String message = "";
		
		for(int i = 0; i < args.length; i++){
			message += args[i] + " ";
		}
		
		for(Player pl : Bukkit.getServer().getOnlinePlayers()){
			if(pl.hasPermission("staff.chat")){
				pl.sendMessage("§9Admin Chat> §7" + sender.getName() + " §8> §7" + message);
			}
		}
		if(!sender.hasPermission("staff.chat.reply")){
			sender.sendMessage("§9Admin Chat> §7" + sender.getName() + " §8> §7" + message);	
		}
		return true;
	}

}
