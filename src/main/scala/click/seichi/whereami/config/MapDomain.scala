package click.seichi.whereami.config

import org.bukkit.plugin.java.JavaPlugin

object MapDomain {
  private val configPath = "map-domain"
  private val errMessage = "The config value ('map-domain') is not set."
  private var value: String = ""

  def load()(implicit instance: JavaPlugin): Unit = {
    instance.reloadConfig()
    val newValue = instance.getConfig.getString(configPath)
    require(newValue.nonEmpty, errMessage)

    value = newValue
  }

  def get(): String = value
}
