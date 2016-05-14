package ga.unbinding.forsakencore;

import org.bukkit.command.CommandSender;

public class MM {
	public static enum MessageType{
		Member, Recruit, Mod, Admin
	}
	
	public static void message(CommandSender sender, @SuppressWarnings("rawtypes") Enum type){
		if(type == MessageType.Member){
			sender.sendMessage("§9Permissions> §7The [MEMBER] rank is required for this.");
			return;
		}
		if(type == MessageType.Recruit){
			sender.sendMessage("§9Permissions> §7The §3[RECRUIT] §7rank is required for this.");
			return;
		}
		if(type == MessageType.Mod){
			sender.sendMessage("§9Permissions> §7The §9[MOD] §7rank is required for this.");
			return;
		}
		if(type == MessageType.Admin){
			sender.sendMessage("§9Permissions> §7The §c[ADMIN] §7rank is required for this.");
			return;
		}
	}
}
