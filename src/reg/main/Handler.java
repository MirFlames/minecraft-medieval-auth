package reg.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
// import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class Handler implements Listener {

		@EventHandler
		public void spawned(PlayerSpawnLocationEvent e) {
			Player p = e.getPlayer();
			// World regWorld = Bukkit.getWorld("world");
			// Location spawnCoords = regWorld.getSpawnLocation();
			p.teleport(new Location(Bukkit.getServer().getWorld("world"), 150, 150, 150));
			Bukkit.getServer().broadcastMessage("spawned Ник: " + p.getDisplayName());
			p.sendMessage("Хуй");
		}
	
		@EventHandler
		public void join(PlayerJoinEvent e) {
			
			Player p = e.getPlayer();
			Bukkit.getServer().broadcastMessage("join Ник: " + p.getDisplayName());
			// World regWorld = Bukkit.getWorld("world");
			// Location spawnCoords = regWorld.getSpawnLocation();
			p.teleport(new Location(Bukkit.getServer().getWorld("world"), 150, 150, 150));
			
			p.sendMessage("Тест");
		}
		
}
