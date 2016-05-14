package ga.unbinding.forsakencore.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;

public class CoriCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!sender.hasPermission("admin.cori")){
			MM.message(sender, MessageType.Admin);
			return true;
		}
		sender.sendMessage("§9Cori> §7She's the most amazing girl ever c:");
		return true;
	}

}
