package de.philgamer.gui

import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.PageChangeEffect
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.axay.kspigot.items.customModel
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class AdminGUI {
    val gui = kSpigotGUI(GUIType.FIVE_BY_NINE) {
        title = "§cAdmin Menu"

        //Items:
        val ph = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
        val phMeta = ph.itemMeta
        phMeta?.setDisplayName("§4")
        phMeta?.customModel = 1
        ph.itemMeta = phMeta

        val paper = ItemStack(Material.PAPER)
        val paperMeta = paper.itemMeta
        paperMeta?.setDisplayName("§6»Nächste Seite")
        paper.itemMeta = paperMeta

        val soon = ItemStack(Material.REDSTONE)
        val soonMeta = soon.itemMeta
        soonMeta?.setDisplayName("§c»Soon")
        soon.itemMeta = soonMeta

        val gm1 = ItemStack(Material.GRASS_BLOCK)
        val gm1Meta = gm1.itemMeta
        gm1Meta?.setDisplayName("§aGamemode Creative")
        gm1.itemMeta = gm1Meta

        val paperback = ItemStack(Material.PAPER)
        val paperBackMeta = paperback.itemMeta
        paperBackMeta?.setDisplayName("§6»Letzte Seite")
        paperback.itemMeta = paperBackMeta

        val gm0 = ItemStack(Material.NETHERRACK)
        val gm0Meta = gm0.itemMeta
        gm0Meta?.setDisplayName("§cGamemode Survival")
        gm0.itemMeta = gm0Meta

        val gm2 = ItemStack(Material.CHEST)
        val gm2Meta = gm2.itemMeta
        gm2Meta?.setDisplayName("§eGamemode Adventure")
        gm2.itemMeta = gm2Meta

        val gm3 = ItemStack(Material.GRAY_STAINED_GLASS)
        val gm3Meta = gm3.itemMeta
        gm3Meta?.setDisplayName("§7Gamemode Spectator")
        gm3.itemMeta = gm3Meta
        page(0) {
            placeholder(Slots.All, ph)
            nextPage(Slots.RowOneSlotNine, paper)

            button(Slots.RowThreeSlotFour, gm1) {
                it.player.gameMode = GameMode.CREATIVE

            }
            button(Slots.RowThreeSlotThree, gm0) {
                it.player.gameMode = GameMode.SURVIVAL
            }

            button(Slots.RowThreeSlotFive, gm2) {
                it.player.gameMode = GameMode.ADVENTURE
            }
            button(Slots.RowThreeSlotSix, gm3) {
                it.player.gameMode = GameMode.SPECTATOR
            }
            }
        page(1) {
            transitionFrom = PageChangeEffect.SLIDE_HORIZONTALLY
            transitionTo = PageChangeEffect.SLIDE_HORIZONTALLY

            placeholder(Slots.All, soon)
            nextPage(Slots.RowOneSlotNine, paper)
            previousPage(Slots.RowOneSlotOne, paperback)
        }

    }
}