package de.elia.soulboss.messages.message;

import de.elia.soulboss.messages.prefix.CustomPrefix;
import de.elia.soulmain.SoulMain;
import de.elia.soulmain.allplugins.messages.builder.MessageBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

/**
 * @author Elia
 * @version 1.0
 * @since 1.0
 * @extends {@link MessageBuilder}
 * @description This is the MessageClass for this Plugin.
 */
public class CustomMessages extends MessageBuilder {

  private final MiniMessage miniMessage = SoulMain.getMiniMessage();
  private final Logger logger = Bukkit.getLogger();
  private final CustomPrefix prefix = new CustomPrefix();

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This Methode send an information in the console.
   * @param message Requires the log message.
   */
  @Override
  public void infoLog(String message) {
    this.logger.info(prefix.consolePrefix() + message);
  }

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This Methode send a warning in the console.
   * @param message Requires the log message.
   */
  @Override
  public void warningLog(String message) {
    this.logger.warning(prefix.warningPrefix() + message);
  }

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This Methode send an error in the console.
   * @param message Requires the log message.
   */
  @Override
  public void errorLog(String message) {
    this.logger.severe(prefix.errorPrefix() + message);
  }

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This Methode send a broadcast to all players.
   * @param message Requires the broadcast message.
   */
  @Override
  public void broadcastWithPrefix(String message) {
    Bukkit.broadcast(this.miniMessage.deserialize(prefix.prefix() + message));
  }

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This Methode send a message to a player.
   * @param player Requires a Player.
   * @param message Requires the message.
   */
  @Override
  public void messageWithPrefix(@NotNull Player player, String message) {
    player.sendMessage(this.miniMessage.deserialize(prefix.prefix() + message));
  }

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This Methode send a message to a player.
   * @param player Requires a Player.
   * @param message Requires the message.
   */
  @Override
  public void messageWithPrefix(@NotNull Player player, Component message) {
    player.sendMessage(this.prefix.prefix().append(message));
  }

  /**
   * @author Elia
   * @version 1.0
   * @since 1.0
   * @description This Methode send a message to a CommmandSender.
   * @param sender Requires a CommandSender.
   * @param message Requires the message.
   */
  @Override
  public void messageWithPrefix(@NotNull CommandSender sender, String message) {
    sender.sendMessage(this.miniMessage.deserialize(prefix.prefix() + message));
  }

}
