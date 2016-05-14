package ga.unbinding.forsakencore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ga.unbinding.forsakencore.cmds.VanishCommand;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		if(e.getPlayer().hasPermission("admin.silentjoin")){
			e.setJoinMessage(null);
		}
		if(e.getPlayer().hasPermission("admin.silentjoin.vanish")){
			VanishCommand.vanish(e.getPlayer());
		}
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		if(e.getPlayer().hasPermission("admin.silentquit")){
			e.setQuitMessage(null);
		}
		
		if(VanishCommand.vanished.contains(e.getPlayer())){
			VanishCommand.vanished.remove(e.getPlayer());
		}
		
	}

}
