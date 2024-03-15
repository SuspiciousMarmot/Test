package org.mineacademy.template;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.permissions.Permission;
import org.mineacademy.fo.plugin.SimplePlugin;

/**
 * PluginTemplate is a simple template you can use every time you make
 * a new plugin. This will save you time because you no longer have to
 * recreate the same skeleton and features each time.
 * <p>
 * It uses Foundation for fast and efficient development process.
 */
public final class PluginTemplate extends SimplePlugin {
	Permission frost = new Permission("frost", "This permission allows you to freeze entities when right clicking");


	int sec(int seconds) {
		return 20 * seconds;
	}

	/**
	 * Automatically perform login ONCE when the plugin starts.
	 */
	@Override
	protected void onPluginStart() {
		System.out.println("Plugin enabled");
	}



	/* ------------------------------------------------------------------------------- */
	/* Events */
	/* ------------------------------------------------------------------------------- */

	/**
	 * This event would recive a player click on entity event and decide the entity to explode on right click
	 *
	 * @param event
	 */
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent event) {
		if (event.getRightClicked().getType() == EntityType.COW)
			event.getRightClicked().getWorld().createExplosion(event.getRightClicked().getLocation(), 5);
		else if (event.getPlayer().hasPermission(frost)) {
			event.getRightClicked().setFreezeTicks(sec((int) event.getPlayer().getLevel()));
		}
	}
}