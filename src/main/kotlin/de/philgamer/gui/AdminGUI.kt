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
        val ph = ItemStack(Material.GLASS)
        val phMeta = ph.itemMeta
        phMeta?.setDisplayName("")
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

        page(0) {
            placeholder(Slots.Border, ph)
            nextPage(Slots.RowOneSlotNine, paper)

            button(Slots.RowTwoSlotThree, gm1) {
                it.player.gameMode = GameMode.CREATIVE

            }
            }
        page(1) {
            transitionFrom = PageChangeEffect.SLIDE_HORIZONTALLY
            transitionTo = PageChangeEffect.SLIDE_HORIZONTALLY

            placeholder(Slots.All, soon)
            nextPage(Slots.RowOneSlotNine, paperback)
            previousPage(Slots.RowOneSlotOne, paperback)
        }

    }
}