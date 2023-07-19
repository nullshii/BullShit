package com.nullshii.bullshit.Listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class GiveRandomBullShitToPlayer implements Listener {
    private final Random random;

    public GiveRandomBullShitToPlayer() {
        random = new Random();
    }

    @EventHandler
    public void onPlayerTakeDamageFromEntity(EntityDamageByEntityEvent entityDamageEvent) {
        if (!(entityDamageEvent.getEntity() instanceof LivingEntity livingEntity)) return;

        PotionEffectType randomPotion = getRandomPotion();
        int amplifier = random.nextInt(255) + 1;
        int duration = random.nextInt(2400 - 40 + 1) + 40;

        entityDamageEvent.getDamager().sendMessage(Component.text("You give %s %s for %s seconds to %s".formatted(
                randomPotion.getName(),
                amplifier,
                (duration / 20),
                livingEntity.getName()
        )).color(TextColor.color(0.2f, 1f, 0.2f)));

        livingEntity.sendMessage(Component.text("You got %s %s for %s seconds by %s".formatted(
                randomPotion.getName(),
                amplifier,
                (duration / 20),
                entityDamageEvent.getDamager().getName()
        )).color(TextColor.color(1f, 0.2f, 0.2f)));

        livingEntity.addPotionEffect(new PotionEffect(randomPotion, duration, amplifier)); // 20 ticks * seconds
    }

    private PotionEffectType getRandomPotion() {
        int id = random.nextInt(33) + 1;

        return switch (id) {
            default -> PotionEffectType.SPEED;
            case 2 -> PotionEffectType.SLOW;
            case 3 -> PotionEffectType.FAST_DIGGING;
            case 4 -> PotionEffectType.SLOW_DIGGING;
            case 5 -> PotionEffectType.INCREASE_DAMAGE;
            case 6 -> PotionEffectType.HEAL;
            case 7 -> PotionEffectType.HARM;
            case 8 -> PotionEffectType.JUMP;
            case 9 -> PotionEffectType.CONFUSION;
            case 10 -> PotionEffectType.REGENERATION;
            case 11 -> PotionEffectType.DAMAGE_RESISTANCE;
            case 12 -> PotionEffectType.FIRE_RESISTANCE;
            case 13 -> PotionEffectType.WATER_BREATHING;
            case 14 -> PotionEffectType.INVISIBILITY;
            case 15 -> PotionEffectType.BLINDNESS;
            case 16 -> PotionEffectType.NIGHT_VISION;
            case 17 -> PotionEffectType.HUNGER;
            case 18 -> PotionEffectType.WEAKNESS;
            case 19 -> PotionEffectType.POISON;
            case 20 -> PotionEffectType.WITHER;
            case 21 -> PotionEffectType.HEALTH_BOOST;
            case 22 -> PotionEffectType.ABSORPTION;
            case 23 -> PotionEffectType.SATURATION;
            case 24 -> PotionEffectType.GLOWING;
            case 25 -> PotionEffectType.LEVITATION;
            case 26 -> PotionEffectType.LUCK;
            case 27 -> PotionEffectType.UNLUCK;
            case 28 -> PotionEffectType.SLOW_FALLING;
            case 29 -> PotionEffectType.CONDUIT_POWER;
            case 30 -> PotionEffectType.DOLPHINS_GRACE;
            case 31 -> PotionEffectType.BAD_OMEN;
            case 32 -> PotionEffectType.HERO_OF_THE_VILLAGE;
            case 33 -> PotionEffectType.DARKNESS;
        };
    }
}
