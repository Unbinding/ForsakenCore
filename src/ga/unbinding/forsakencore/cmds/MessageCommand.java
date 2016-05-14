package ga.unbinding.forsakencore.cmds;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.unbinding.forsakencore.MM;
import ga.unbinding.forsakencore.MM.MessageType;
import net.md_5.bungee.api.ChatColor;

public class MessageCommand implements CommandExecutor {

	private HashMap<Player, Player> replies = new HashMap<Player, Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		
		Player p = (Player) sender;
		if(commandLabel.equalsIgnoreCase("message")){
			if(sender.hasPermission("normal.message")){
				if(args.length <= 1){
					sender.sendMessage("§9Message> §7/message <player> <message>");
					return true;
				}
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if(t == null){
					sender.sendMessage("§9Message> §7That player isn't online.");
					return true;
				}
				String message = "";
				for(int i = 1; i < args.length; i++){
					message += args[i] + " ";
				}
				
				t.sendMessage("§c" + p.getName() + " §4§l> §c" + t.getName() + "§4: §c" + message);
				p.sendMessage("§c" + p.getName() + " §4§l> §c" + t.getName() + "§4: §c" + message);
				replies.put(p, t);
			}else{
				MM.message(sender, MessageType.Member);
				return true;
			}	
		}
		
		if(commandLabel.equalsIgnoreCase("reply")){
			if(!sender.hasPermission("normal.message.reply")){
				MM.message(sender, MessageType.Member);
				return true;
			}
			if(args.length == 0){
				sender.sendMessage("§9Message> §7/reply <message>");
				return true;
			}
			String message = "";
			for(int i = 0; i < args.length; i++){
				message += args[i] + " ";
			}
		
            Player r = (Player) replies.get(sender);
            
            if(r == null) {
                sender.sendMessage("§9Message> §7You haven't messaged anybody recently.");
                return true;
            }else{
				r.sendMessage("§c" + sender.getName() + " §4§l> §c" + r.getName() + "§4: §c" + message);
				sender.sendMessage("§c" + sender.getName() + " §4§l> §c" + r.getName() + "§4: §c" + message);
			}
		}
		return true;
	}

}
