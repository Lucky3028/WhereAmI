package click.seichi.whereami.config

import org.bukkit.plugin.java.JavaPlugin

object MapDomain {
  private val configPath = "map-domain"
  private val errMessage = "The config value ('map-domain') is not set."
  private var value: Option[String] = None

  def load()(implicit instance: JavaPlugin): Unit = {
    instance.reloadConfig()
    val newValue = Option(instance.getConfig.getString(configPath))
    require(newValue.isDefined, errMessage)

    value = newValue
  }

  def get(): Option[String] = {
    require(value.isDefined, errMessage)

    value
  }
}
