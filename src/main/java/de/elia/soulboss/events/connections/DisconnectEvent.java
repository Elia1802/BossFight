package de.elia.soulboss.events.connections;

import de.elia.soulboss.commands.mob.SpawnMobCommand;
import de.elia.soulboss.fight.BossFightManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author Elia
 * @version 1.0
 * @since 1.0
 * @implements {@link Listener}
 * @description This is the Listener for removing the boss if the player disconnected.
 */
public class DisconnectEvent implements Listener {

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This is the Event for removing the boss if the player disconnected.
   * @param event Requires the {@link PlayerQuitEvent}
   */
  @EventHandler
  public void onPlayerDisconnect(@NotNull PlayerQuitEvent event){
    BossFightManager bossFightManager = new BossFightManager();
    if (bossFightManager.playerHasStart(event.getPlayer())) {
      if (SpawnMobCommand.getBossFight() == null)return;
      SpawnMobCommand.getBossFight().stopFight(true);
    }
  }

}
