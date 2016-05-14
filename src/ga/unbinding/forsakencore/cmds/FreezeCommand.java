package ga.unbinding.forsakencore.cmds;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;

public class FreezeCommand implements CommandExecutor{
	
	public static ArrayList<String> frozen = new ArrayList<String>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!sender.hasPermission("staff.freeze")){
			MM.message(sender, MessageType.Mod);
			return true;
		}
		
		sender.sendMessage("§9Freeze> §7This feature is coming soon!");
		
//		if(args.length == 0){
//			sender.sendMessage("§9Freeze> §7/freeze <player>");
//			return true;
//		}
//		Player t = Bukkit.getServer().getPlayer(args[0]);
//		if(t == null){
//			sender.sendMessage("§9Freeze> §7That player isn't online.");
//			return true;
//		}
//		
//		if(!frozen.contains(t.getName())){
//			frozen.add(t.getName());
//			sender.sendMessage("§9Freeze> §7" + t.getName() + " has been frozen.");
//			t.sendMessage("§9Freeze> §7You have been frozen!");
//		}else{
//			frozen.remove(t.getName());
//			sender.sendMessage("§9Freeze> §7" + t.getName() + " has been unfrozen.");
//			t.sendMessage("§9Freeze> §7You have been unfrozen!");
//		}
//		
		return true;
	}
	
	

}
