package reg.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MedievalRegistration extends JavaPlugin {
	
	FileConfiguration config = getConfig();
	
	public void changeConfigVariable(String var, int value) {
		config.set(var, value);
		saveConfig();
	}
	
	public int getConfigVariable(String var) {
		return config.getInt(var);
	}
	
	public void onEnable() {
		getLogger().info("Medieval Registration started");
		
		if (Bukkit.getWorld("world_reg") == null) {
			Bukkit.createWorld(new WorldCreator("world_reg"));
		}
		Bukkit.getPluginManager().registerEvents(new Handler(), this);
	}
	
	public void onDisable() {
		getLogger().info("Medieval Registration disabled");
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String args[]) {
		
		if(cmd.getName().equalsIgnoreCase("test")) {
			
			s.sendMessage("Привет");
			Player p = (Player) s;
			p.sendMessage("Тест тест тест заебал блять");
			boolean result = p.teleport(p.getLocation());
			p.sendMessage("Результат: " + result);
			return true;
			
		}
		
		return false;

	}
	
}
