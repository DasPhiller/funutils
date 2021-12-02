package de.philgamer.commands

import de.philgamer.gui.AdminGUI
import net.axay.kspigot.gui.openGUI
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AdminCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            return true
        }
        val player: Player = sender
        if (player.isOp) {
            player.openGUI(AdminGUI().gui, page = 0)
        } else {
            player.sendMessage("§cDazu hast du keine Rechte!")
        }
        return true
    }
}