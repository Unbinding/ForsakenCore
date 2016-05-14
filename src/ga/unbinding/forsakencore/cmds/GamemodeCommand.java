package ga.unbinding.forsakencore.cmds;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!sender.hasPermission("admin.gamemode")){
			MM.message(sender, MessageType.Admin);
			return true;
		}
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can use this command");
			return true;
		}
		
		Player p = (Player)sender;
		
		if(args.length == 0){
			sender.sendMessage("§9Gamemode> §7/gm <Gamemode>");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("0") | args[0].equalsIgnoreCase("survival")){
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage("§9Gamemode> §7Set your gamemode to survival!");
		}else if(args[0].equalsIgnoreCase("1") | args[0].equalsIgnoreCase("creative")){
			p.setGameMode(GameMode.CREATIVE);
			p.sendMessage("§9Gamemode> §7Set your gamemode to creative!");
		}else if(args[0].equalsIgnoreCase("2") | args[0].equalsIgnoreCase("adventure")){
			p.setGameMode(GameMode.ADVENTURE);
			p.sendMessage("§9Gamemode> §7Set your gamemode to adventure!");
		}else{
			sender.sendMessage("§9Gamemode> §cInvalid gamemode!");
			return true;
		}
		
		
		return true;
	}
}
