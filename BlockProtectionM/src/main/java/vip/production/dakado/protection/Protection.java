package vip.production.dakado.protection;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Protection extends JavaPlugin implements Listener {

	
	
	public void onEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.saveDefaultConfig();
		
	}
	
	public void onDisable() {
		
	}
	

	 @EventHandler
	  public void onBlockPhysics(BlockPhysicsEvent event)
	  {
		 if (getConfig().getBoolean("fyzika") == true) {
	      event.setCancelled(true);
		 }
	  }

	  @EventHandler
	  public void onBlockBurn(BlockBurnEvent event)
	  {
		  if (getConfig().getBoolean("horeni") == true) {
	      event.setCancelled(true);
		  }
	  }

	  @EventHandler
	  public void onBlockIgnite(BlockIgniteEvent event)
	  {
		  if (getConfig().getBoolean("fyzika") == true) {
	    if ((
	      (event.getCause() == BlockIgniteEvent.IgniteCause.SPREAD) || 
	      (event.getCause() == BlockIgniteEvent.IgniteCause.LAVA) || 
	      (event.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING)))
	      event.setCancelled(true);
		  }
	  }

	  @EventHandler
	  public void onBlockFromTo(BlockFromToEvent event)
	  {
		  if (getConfig().getBoolean("formovanibloku") == true) {
	      event.setCancelled(true);
		  }
	  }

	  @EventHandler
	  public void onBlockFade(BlockFadeEvent event)
	  {
		  if (getConfig().getBoolean("zvadnuti") == true) {
	      event.setCancelled(true);
		  }
	  }

	  @EventHandler
	  public void onBlockGrow(BlockGrowEvent event)
	  {
		  if (getConfig().getBoolean("rustbloku") == true) {
	      event.setCancelled(true);
		  }
	  }

	  @EventHandler
	  public void onBlockForm(BlockFormEvent event)
	  {
		  if (getConfig().getBoolean("formovanibloku") == true) {
	      event.setCancelled(true);
		  }
	  }

	  @EventHandler
	  public void onBlockSpread(BlockSpreadEvent event)
	  {
		  if (getConfig().getBoolean("horeni") == true) {
	      event.setCancelled(true);
		  }
	  }
	  
	  @EventHandler
	  public void onWeather(WeatherChangeEvent e) {
		  if (getConfig().getBoolean("vypnoutpocasi") == true) {
			  e.setCancelled(true);
		  }
	  }

}
