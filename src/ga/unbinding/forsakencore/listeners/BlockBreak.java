package ga.unbinding.forsakencore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreak implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(!e.getPlayer().hasPermission("admin.build")){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		if(!e.getPlayer().hasPermission("admin.build")){
			e.setCancelled(true);
		}
	}

}
