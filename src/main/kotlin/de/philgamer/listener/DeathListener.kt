package de.philgamer.listener

import net.axay.kspigot.chat.KColors
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.inventory.ItemStack

class DeathListener : Listener {

    @EventHandler
    fun deathEvent(event: PlayerDeathEvent) {
        event.deathMessage = KColors.RED.toString() + event.entity.name + " ist Gestorben!"
        event.entity.inventory.setItem(0, ItemStack(Material.OAK_BOAT))
    }
}