package click.seichi.whereami

import org.bukkit.plugin.java.JavaPlugin

class WhereAmI extends JavaPlugin {
  override def onEnable(): Unit = {
    this.getLogger.info("WhereAmI is enabled.")
  }
}
