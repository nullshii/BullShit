package com.nullshii.bullshit.Listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class LevitatePlayer implements Listener {
    @EventHandler
    public void onPlayerTakeDamage(EntityDamageEvent entityDamageEvent) {
        if (!(entityDamageEvent.getEntity() instanceof LivingEntity livingEntity)) return;
        if (!entityDamageEvent.getCause().equals(EntityDamageEvent.DamageCause.FALL)) return;

        livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 35, 2)); // 20 ticks * seconds
    }
}
