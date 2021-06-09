package xyz.namutree0345.melonySmp.event

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Skeleton
import org.bukkit.entity.Zombie
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import java.util.*

class CustomEntitySpawn : Listener {

    @EventHandler
    fun spawn(event: EntitySpawnEvent) {

        if(event.entity is Zombie) {
            (event.entity as Zombie).run {
                customName(Component.text("멜로니 좀비", TextColor.color(0x8FFF7D), TextDecoration.BOLD))
                equipment?.helmet = ItemStack(Material.PLAYER_HEAD).let {
                    it.itemMeta = (it.itemMeta as SkullMeta).let { im ->
                        // Me1ony UUID
                        im.owningPlayer = Bukkit.getOfflinePlayer(UUID.fromString("255ca5b2-2da3-4030-a747-5c224224a611"))
                        im
                    }
                    it
                }
                equipment?.helmetDropChance = 0.0F
                equipment?.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
                equipment?.chestplateDropChance = 0.0F
                equipment?.setItemInMainHand(ItemStack(Material.IRON_SWORD).let {
                    it.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2)
                    it
                })
            }
        }
        if(event.entity is Skeleton) {
            (event.entity as Skeleton).run {
                customName(Component.text("멜로니 스켈레톤", TextColor.color(0x8FFF7D), TextDecoration.BOLD))
                equipment?.helmet = ItemStack(Material.PLAYER_HEAD).let {
                    it.itemMeta = (it.itemMeta as SkullMeta).let { im ->
                        // Me1ony UUID
                        im.owningPlayer = Bukkit.getOfflinePlayer(UUID.fromString("255ca5b2-2da3-4030-a747-5c224224a611"))
                        im
                    }
                    it
                }
                equipment?.helmetDropChance = 0.0F
                equipment?.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
                equipment?.chestplateDropChance = 0.0F
                equipment?.setItemInMainHand(ItemStack(Material.BOW).let {
                    it.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2)
                    it
                })
            }
        }

    }

}