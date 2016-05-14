package ga.unbinding.forsakencore.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class SpeedCommand implements CommandExecutor {

	/* (non-Javadoc)
	 * @see org.bukkit.command.CommandExecutor#onCommand(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String, java.lang.String[])
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!sender.hasPermission("admin.speed")){
			MM.message(sender, MessageType.Admin);
			return true;
		}
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(args.length == 0){
			sender.sendMessage("§9Speed> §7/speed <number>");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("1")){
			if(!p.isFlying()){
				p.setWalkSpeed((float) 0.1);
				sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			}else{
				p.setFlySpeed((float) 0.1);
				sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
			}
		}else if(args[0].equalsIgnoreCase("2")){
			if(!p.isFlying()){
				p.setWalkSpeed((float) 0.2);
				sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			}else{
				sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
				p.setFlySpeed((float) 0.2);
			}
		}else if(args[0].equalsIgnoreCase("3")){
			if(!p.isFlying()){
				p.setWalkSpeed((float) 0.3);
				sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			}else{
				sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
				p.setFlySpeed((float) 0.3);
			}
		}else if(args[0].equalsIgnoreCase("4")){
			if(!p.isFlying()){
				sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
				p.setWalkSpeed((float) 0.4);
			}else{
				sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
				p.setFlySpeed((float) 0.4);
			}
		}else if(args[0].equalsIgnoreCase("5")){
			if(!p.isFlying()){
				sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
				p.setWalkSpeed((float) 0.5);
			}else{
				sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
				p.setFlySpeed((float) 0.5);
			}
		}else if(args[0].equalsIgnoreCase("6")){
		if(!p.isFlying()){
			sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			p.setWalkSpeed((float) 0.6);
		}else{
			sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
			p.setFlySpeed((float) 0.6);
		}
	}else if(args[0].equalsIgnoreCase("7")){
		if(!p.isFlying()){
			sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			p.setWalkSpeed((float) 0.7);
		}else{
			sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
			p.setFlySpeed((float) 0.7);
		}
	}else if(args[0].equalsIgnoreCase("8")){
		if(!p.isFlying()){
			sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			p.setWalkSpeed((float) 0.8);
		}else{
			sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
			p.setFlySpeed((float) 0.8);
		}
	}else if(args[0].equalsIgnoreCase("9")){
		if(!p.isFlying()){
			sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			p.setWalkSpeed((float) 0.9);
		}else{
			sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
			p.setFlySpeed((float) 0.9);
		}
	}else if(args[0].equalsIgnoreCase("10")){
		if(!p.isFlying()){
			sender.sendMessage("§9Speed> §7Adjusted your walk speed.");
			p.setWalkSpeed((float) 1.0);
		}else{
			sender.sendMessage("§9Speed> §7Adjusted your fly speed.");
			p.setFlySpeed((float) 1.0);
		}
	}
		return true;
	}

}
