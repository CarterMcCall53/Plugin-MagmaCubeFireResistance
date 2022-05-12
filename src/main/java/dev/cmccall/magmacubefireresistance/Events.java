package dev.cmccall.magmacubefireresistance;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Events implements Listener {
    @EventHandler
    public void onPlayerHitsMagmaCube(EntityDamageByEntityEvent e) {
        var attacker = e.getDamager().getType();
        if (attacker == EntityType.PLAYER) {
            var victim = e.getEntityType();
            if (victim == EntityType.MAGMA_CUBE) {
                var numGen = Math.random() * 250;
                int num = (int) numGen;
                if (num == 1) {
                    Player player = (Player) e.getDamager();
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 1));
                }
            }
        }
    }
}
