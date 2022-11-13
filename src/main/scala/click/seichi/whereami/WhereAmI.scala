package click.seichi.whereami

import click.seichi.whereami.commands.{Reload, ShowMap}
import click.seichi.whereami.config.MapDomain
import org.bukkit.plugin.java.JavaPlugin

class WhereAmI extends JavaPlugin {
  override def onEnable(): Unit = {
    implicit val instance: WhereAmI = this

    saveDefaultConfig()
    MapDomain.load()

    Map("whereami" -> Reload(), "map" -> ShowMap()).foreach {
      case (commandName, executor) => instance.getCommand(commandName).setExecutor(executor)
    }

    this.getLogger.info("WhereAmI is enabled.")
  }
}
