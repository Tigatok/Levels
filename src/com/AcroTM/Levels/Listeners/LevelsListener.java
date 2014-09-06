package com.AcroTM.Levels.Listeners;

import com.AcroTM.Levels.Driver.LevelsAPI;
import com.AcroTM.Levels.com.AcroTM.Levels.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Tyler on 05/09/2014.
 */
public class LevelsListener implements Listener {

    public LevelsListener() {
        Bukkit.getPluginManager().registerEvents(this, LevelsAPI.getLevels());
    }

    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Material itemInHand = player.getInventory().getItemInHand().getType();
            if (
                    itemInHand == Material.LEATHER_BOOTS ||
                            itemInHand == Material.LEATHER_CHESTPLATE ||
                            itemInHand == Material.LEATHER_HELMET ||
                            itemInHand == Material.LEATHER_LEGGINGS ||

                            itemInHand == Material.IRON_BOOTS ||
                            itemInHand == Material.IRON_LEGGINGS ||
                            itemInHand == Material.IRON_CHESTPLATE ||
                            itemInHand == Material.IRON_HELMET ||

                            itemInHand == Material.GOLD_BOOTS ||
                            itemInHand == Material.GOLD_CHESTPLATE ||
                            itemInHand == Material.GOLD_HELMET ||
                            itemInHand == Material.GOLD_LEGGINGS ||

                            itemInHand == Material.DIAMOND_BOOTS ||
                            itemInHand == Material.DIAMOND_LEGGINGS ||
                            itemInHand == Material.DIAMOND_CHESTPLATE ||
                            itemInHand == Material.DIAMOND_HELMET
                    ) {
                event.setCancelled(true);
            }
        }
    }

    public void onPlayerAttackEvent(EntityDamageByEntityEvent event) {
        Player player = ((Player) event.getDamager()).getPlayer();
        int playerLevel = player.getLevel();
        if (playerLevel < 8) {
            if (player.getInventory().getItemInHand().getType() != Material.WOOD_SWORD) {
                event.setDamage(1.0D);
                player.sendMessage(LevelsAPI.getConfigUtil().getInsufficientLevelMessage());
            }
        } else if (playerLevel < 16) {
            if (player.getInventory().getItemInHand().getType() != Material.GOLD_SWORD || player.getInventory().getItemInHand().getType() != Material.STONE_SWORD) {
                event.setDamage(1.0D);
                player.sendMessage(LevelsAPI.getConfigUtil().getInsufficientLevelMessage());
            }
        }
    }

    public void onPlayerInventoryClickEvent(InventoryClickEvent event) {
        Material material = event.getCurrentItem().getType();
        Player player = ((Player) event.getWhoClicked()).getPlayer();
        if (player.getLevel() < 8) {
            if (
                    material != Material.LEATHER_BOOTS ||
                            material != Material.LEATHER_CHESTPLATE ||
                            material != Material.LEATHER_HELMET ||
                            material != Material.LEATHER_LEGGINGS
                    ) {
                event.setCancelled(true);
                player.sendMessage(LevelsAPI.getConfigUtil().getInsufficientLevelMessage());
            }
        } else if (player.getLevel() < 16) {
            if (
                    material != Material.LEATHER_BOOTS ||
                            material != Material.LEATHER_CHESTPLATE ||
                            material != Material.LEATHER_HELMET ||
                            material != Material.LEATHER_LEGGINGS ||

                            material != Material.GOLD_BOOTS ||
                            material != Material.GOLD_CHESTPLATE ||
                            material != Material.GOLD_HELMET ||
                            material != Material.GOLD_LEGGINGS
                    ) {
                event.setCancelled(true);
                player.sendMessage(LevelsAPI.getConfigUtil().getInsufficientLevelMessage());

            }
        } else if (player.getLevel() < 24) {
            if (
                    material != Material.IRON_BOOTS ||
                            material != Material.IRON_CHESTPLATE ||
                            material != Material.IRON_HELMET ||
                            material != Material.IRON_LEGGINGS
                    ) {
                event.setCancelled(true);
                player.sendMessage(LevelsAPI.getConfigUtil().getInsufficientLevelMessage());

            }
        }
    }
}
