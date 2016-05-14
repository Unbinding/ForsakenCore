package ga.unbinding.forsakencore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import ga.unbinding.forsakencore.cmds.AdminChatCommand;
import ga.unbinding.forsakencore.cmds.CoriCommand;
import ga.unbinding.forsakencore.cmds.FlyCommand;
import ga.unbinding.forsakencore.cmds.FreezeCommand;
import ga.unbinding.forsakencore.cmds.GamemodeCommand;
import ga.unbinding.forsakencore.cmds.MessageCommand;
import ga.unbinding.forsakencore.cmds.ReplyAdminChatCommand;
import ga.unbinding.forsakencore.cmds.SpeedCommand;
import ga.unbinding.forsakencore.cmds.SuicideCommand;
import ga.unbinding.forsakencore.cmds.TeleportCommand;
import ga.unbinding.forsakencore.cmds.TphereCommand;
import ga.unbinding.forsakencore.cmds.VanishCommand;
import ga.unbinding.forsakencore.listeners.BlockBreak;
import ga.unbinding.forsakencore.listeners.JoinListener;
import ga.unbinding.forsakencore.listeners.MoveListener;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new MoveListener(), this);
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("v").setExecutor(new VanishCommand());
		getCommand("suicide").setExecutor(new SuicideCommand());
		getCommand("tp").setExecutor(new TeleportCommand());
		getCommand("tphere").setExecutor(new TphereCommand());
		getCommand("message").setExecutor(new MessageCommand());
		getCommand("msg").setExecutor(new MessageCommand());
		getCommand("reply").setExecutor(new MessageCommand());
		getCommand("r").setExecutor(new MessageCommand());
		getCommand("cori").setExecutor(new CoriCommand());
		getCommand("a").setExecutor(new AdminChatCommand());
		getCommand("ra").setExecutor(new ReplyAdminChatCommand());
		getCommand("speed").setExecutor(new SpeedCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("freeze").setExecutor(new FreezeCommand());
	}
	
	private static Main instance;
	public static Main getInstance(){
		return instance;
	}

}
