package click.seichi.whereami.commands

import click.seichi.whereami.config.MapDomain
import org.bukkit.ChatColor
import org.bukkit.command.{Command, CommandExecutor, CommandSender}
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

case class Reload()(implicit instance: JavaPlugin) extends CommandExecutor {
  override def onCommand(
    commandSender: CommandSender,
    command: Command,
    alias: String,
    args: Array[String]
  ): Boolean = {
    if (!args.headOption.map(_.toLowerCase).contains("reload")) {
      commandSender.sendMessage(s"${ChatColor.RED}Syntax Error!")
      return false
    }
    val perm = "whereami.reload"
    commandSender match {
      case player: Player if !player.hasPermission(perm) =>
        player.sendMessage(
          s"${ChatColor.RED}You don't have the permission ($perm) to use this command."
        )
        return true
      case _ =>
    }

    MapDomain.load()
    commandSender.sendMessage(s"${ChatColor.GREEN}Reloaded WhereAmI config.")

    true
  }
}
