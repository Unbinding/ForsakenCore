package ga.unbinding.forsakencore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class TphereCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		if(!sender.hasPermission("staff.teleport.here")){
			MM.message(sender, MessageType.Mod);
			return true;
		}
		
		Player p = (Player) sender;
		if(args.length == 0){
			sender.sendMessage("§9Teleport> §7/tphere <Player>");
			return true;
		}
		Player t = Bukkit.getServer().getPlayer(args[0]);
		if(t == null){
			sender.sendMessage("§9Teleport> §7That player isn't online.");
			return true;
		}
		t.teleport(p);
		p.sendMessage("§9Teleport> §7You have teleported " + t.getName() + " to you.");
		
		
		return true;
	}
}
