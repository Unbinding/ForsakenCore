package ga.unbinding.forsakencore.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!sender.hasPermission("staff.fly")){
			MM.message(sender, MessageType.Recruit);
			return true;
		}
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.getAllowFlight() == false){
			p.setAllowFlight(true);
			p.sendMessage("§9Fly> §7Flight enabled.");
		}else{
			p.setAllowFlight(false);
			p.sendMessage("§9Fly> §7Flight disabled.");
		}
		return true;
	}

}
