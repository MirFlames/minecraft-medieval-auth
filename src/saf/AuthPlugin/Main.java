package saf.AuthPlugin;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import saf.AuthPlugin.commands.CommandTeleportMe;

public class Main extends JavaPlugin {
	FileConfiguration config = getConfig();
	
	public void onEnable() {
		initConfig();
		initSpawnWorld();
		registerCommands();
		Bukkit.getPluginManager().registerEvents(new Handler(), this);
	}
	
	public void onDisable() {
		
	}
	
	public void changeConfigVariable(String var, int value) {
		config.set(var, value);
		saveConfig();
	}
	
	public int getConfigVariable(String var) {
		return config.getInt(var);
	}
	
	private void registerCommands() {
		getCommand("teleportme").setExecutor(new CommandTeleportMe());
	}
	
	private void initConfig() {
		config.addDefault("spawnWorld", "world");
		config.options().copyDefaults(true);
		saveConfig();
	}
	
	private void initSpawnWorld() {
		String spawnWorldName = config.getString("spawnWorld");
		
		if (Bukkit.getWorld(spawnWorldName) == null) {
			Bukkit.createWorld(new WorldCreator(spawnWorldName));
		}
	}
}
