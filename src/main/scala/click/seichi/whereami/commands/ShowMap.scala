package click.seichi.whereami.commands

import click.seichi.whereami.config.MapDomain
import org.bukkit.ChatColor
import org.bukkit.command.{Command, CommandExecutor, CommandSender}
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

case class ShowMap()(implicit instance: JavaPlugin) extends CommandExecutor {
  override def onCommand(
    commandSender: CommandSender,
    command: Command,
    alias: String,
    args: Array[String]
  ): Boolean = {
    val player = commandSender match {
      case p: Player => p
      case others =>
        others.sendMessage(s"${ChatColor.RED}You must be a player to use this command.")
        return true
    }
    val perm = "whereami.map"
    if (!player.hasPermission(perm)) {
      player.sendMessage(
        s"${ChatColor.RED}You don't have the permission ($perm) to use this command."
      )
      return true
    }

    val mapDomain = MapDomain.get().getOrElse {
      player.sendMessage(
        s"${ChatColor.RED}The map's domain is not set. Please contact to server administrators."
      )
      return true
    }
    val location = player.getLocation
    val url =
      s"$mapDomain?worldname=${location.getWorld.getName}&mapname=flat&zoom=2&x=${location.getBlockX}&y=${location.getBlockY}&z=${location.getBlockZ}"
    player.sendMessage(s"${ChatColor.GREEN}Here is your map!: $url")

    true
  }
}
