package ga.unbinding.forsakencore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class ReplyAdminChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		if(!sender.hasPermission("staff.chat.reply")){
			MM.message(sender, MessageType.Recruit);
			return true;
		}
		
		if(args.length <= 1){
			sender.sendMessage("§9Admin Chat> §7/ra <player> <message>");
			return true;
		}
		
		Player t = Bukkit.getServer().getPlayer(args[0]);
		if(t == null){
			sender.sendMessage("§9Admin Chat> §7That player isn't online.");
			return true;
		}
		
		String message = "";
		for(int i = 1; i < args.length; i++){
			message += args[i] + "";
		}
		
		t.sendMessage("§9Admin Chat> §7" + sender.getName() + " §8> §7" + message);
		sender.sendMessage("§9Admin Chat> §7" + sender.getName() + " §8> §7" + message);
		return true;
	}
	
	

}
