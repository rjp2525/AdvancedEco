package me.rjp2525.adveco.listeners;

import me.rjp2525.adveco.AdvancedEco;
import me.rjp2525.adveco.config.MobMoneyMainConfig;
import me.rjp2525.adveco.util.Accounting;

import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobMoneyListener
  implements Listener
{
  @EventHandler
  public void playerKillsMonster(EntityDeathEvent event)
  {
    if ((event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
      EntityDamageEvent cause = event.getEntity().getLastDamageCause();
      if (!(((EntityDamageByEntityEvent)cause).getDamager() instanceof Player)) {
        return;
      }
      Player p = (Player)((EntityDamageByEntityEvent)cause.getEntity().getLastDamageCause()).getDamager();

      for (Monsters monster : Monsters.values())
        if (getEntityType(event.getEntity()) == monster.getType()) {
          double reward = getMoney(monster.getName());
          if (reward > 0.0D) {
            if ((reward <= 1.0D) && (reward > 0.0D))
              p.sendMessage(AdvancedEco.pMsg("You got " + String.valueOf(reward) + " " + MobMoneyMainConfig.creditS + " for killing a " + monster.getName() + "!"));
            else {
              p.sendMessage(AdvancedEco.pMsg("You got " + String.valueOf(reward) + " " + MobMoneyMainConfig.credit + " for killing a " + monster.getName() + "!"));
            }
          }

          if (reward < 0.0D) {
            if ((reward > -1.0D) && (reward < 0.0D))
              p.sendMessage(AdvancedEco.pMsg(String.valueOf(reward) + MobMoneyMainConfig.creditS + " was taken away from you for killing a " + monster.getName() + "!"));
            else {
              p.sendMessage(AdvancedEco.pMsg(String.valueOf(reward) + MobMoneyMainConfig.credit + " was taken away from you for killing a " + monster.getName() + "!"));
            }
          }

          double current = Accounting.getBalance(p, AdvancedEco.accounts);
          Accounting.write(p, current + reward, AdvancedEco.accounts);
        }
    }
  }

  private double getMoney(String type)
  {
    if (type.equals(Monsters.BAT.getName()))
      return MobMoneyMainConfig.bat;
    if (type.equals(Monsters.CHICKEN.getName()))
      return MobMoneyMainConfig.chicken;
    if (type.equals(Monsters.COW.getName()))
      return MobMoneyMainConfig.cow;
    if (type.equals(Monsters.MOOSHROOM.getName()))
      return MobMoneyMainConfig.mooshroom;
    if (type.equals(Monsters.OCELOT.getName()))
      return MobMoneyMainConfig.ocelot;
    if (type.equals(Monsters.PIG.getName()))
      return MobMoneyMainConfig.pig;
    if (type.equals(Monsters.SHEEP.getName()))
      return MobMoneyMainConfig.sheep;
    if (type.equals(Monsters.SQUID.getName()))
      return MobMoneyMainConfig.squid;
    if (type.equals(Monsters.VILLAGER.getName()))
      return MobMoneyMainConfig.villager;
    if (type.equals(Monsters.ENDERMAN.getName()))
      return MobMoneyMainConfig.enderman;
    if (type.equals(Monsters.WOLF.getName()))
      return MobMoneyMainConfig.wolf;
    if (type.equals(Monsters.ZOMBIEPIGMAN.getName()))
      return MobMoneyMainConfig.zombiepigman;
    if (type.equals(Monsters.BLAZE.getName()))
      return MobMoneyMainConfig.blaze;
    if (type.equals(Monsters.CAVESPIDER.getName()))
      return MobMoneyMainConfig.cavespider;
    if (type.equals(Monsters.CREEPER.getName()))
      return MobMoneyMainConfig.creeper;
    if (type.equals(Monsters.GHAST.getName()))
      return MobMoneyMainConfig.ghast;
    if (type.equals(Monsters.MAGMACUBE.getName()))
      return MobMoneyMainConfig.magmacube;
    if (type.equals(Monsters.SKELETON.getName()))
      return MobMoneyMainConfig.skeleton;
    if (type.equals(Monsters.SLIME.getName()))
      return MobMoneyMainConfig.slime;
    if (type.equals(Monsters.SPIDER.getName()))
      return MobMoneyMainConfig.spider;
    if (type.equals(Monsters.WITCH.getName()))
      return MobMoneyMainConfig.witch;
    if (type.equals(Monsters.ZOMBIE.getName()))
      return MobMoneyMainConfig.zombie;
    if (type.equals(Monsters.ENDERDRAGON.getName()))
      return MobMoneyMainConfig.enderdragon;
    if (type.equals(Monsters.WITHER.getName()))
      return MobMoneyMainConfig.wither;
    if (type.equals(Monsters.PLAYER.getName()))
        return MobMoneyMainConfig.player;
    if (type.equals(Monsters.SNOWMAN.getName()))
        return MobMoneyMainConfig.snowman;
    if (type.equals(Monsters.GIANT.getName())) {
      return MobMoneyMainConfig.giant;
    }
    return 1.0D;
  }

  public EntityType getEntityType(LivingEntity entity) {
    if ((entity instanceof Bat))
      return EntityType.BAT;
    if ((entity instanceof Chicken))
      return EntityType.CHICKEN;
    if ((entity instanceof Cow))
      return EntityType.COW;
    if ((entity instanceof MushroomCow))
      return EntityType.MUSHROOM_COW;
    if ((entity instanceof Ocelot))
      return EntityType.OCELOT;
    if ((entity instanceof Pig))
      return EntityType.PIG;
    if ((entity instanceof Sheep))
      return EntityType.SHEEP;
    if ((entity instanceof Squid))
      return EntityType.SQUID;
    if ((entity instanceof Villager))
      return EntityType.VILLAGER;
    if ((entity instanceof Enderman))
      return EntityType.ENDERMAN;
    if ((entity instanceof Wolf))
      return EntityType.WOLF;
    if ((entity instanceof PigZombie))
      return EntityType.PIG_ZOMBIE;
    if ((entity instanceof Blaze))
      return EntityType.BLAZE;
    if ((entity instanceof CaveSpider))
      return EntityType.CAVE_SPIDER;
    if ((entity instanceof Creeper))
      return EntityType.CREEPER;
    if ((entity instanceof Ghast))
      return EntityType.GHAST;
    if ((entity instanceof MagmaCube))
      return EntityType.MAGMA_CUBE;
    if ((entity instanceof Skeleton))
      return EntityType.SKELETON;
    if ((entity instanceof Slime))
      return EntityType.SLIME;
    if (((entity instanceof Spider)) && (!(entity instanceof CaveSpider)))
      return EntityType.SPIDER;
    if ((entity instanceof Witch))
      return EntityType.WITCH;
    if ((entity instanceof Zombie))
      return EntityType.ZOMBIE;
    if ((entity instanceof EnderDragon))
      return EntityType.ENDER_DRAGON;
    if ((entity instanceof Wither))
      return EntityType.WITHER;
    if ((entity instanceof Giant))
      return EntityType.GIANT;
    if ((entity instanceof Player))
        return EntityType.PLAYER;
    if ((entity instanceof Snowman))
        return EntityType.SNOWMAN;
    if ((entity instanceof Silverfish))
      return EntityType.SILVERFISH;
    return null;
  }

  private static enum Monsters {
    BAT("Bat", EntityType.BAT), 
    CHICKEN("Chicken", EntityType.CHICKEN), 
    COW("Cow", EntityType.COW), 
    MOOSHROOM("Mooshroom", EntityType.MUSHROOM_COW), 
    OCELOT("Ocelot", EntityType.OCELOT), 
    PIG("Pig", EntityType.PIG), 
    SHEEP("Sheep", EntityType.SHEEP), 
    SQUID("Squid", EntityType.SQUID), 
    VILLAGER("Villager", EntityType.VILLAGER), 
    ENDERMAN("Enderman", EntityType.ENDERMAN), 
    WOLF("Wolf", EntityType.WOLF), 
    ZOMBIEPIGMAN("ZombiePigman", EntityType.PIG_ZOMBIE), 
    BLAZE("Blaze", EntityType.BLAZE), 
    CAVESPIDER("CaveSpidern", EntityType.CAVE_SPIDER), 
    CREEPER("Creeper", EntityType.CREEPER), 
    GHAST("Ghast", EntityType.GHAST), 
    MAGMACUBE("MagmaCube", EntityType.MAGMA_CUBE), 
    SKELETON("Skeleton", EntityType.SKELETON), 
    SLIME("Slime", EntityType.SLIME), 
    SPIDER("Spider", EntityType.SPIDER), 
    WITCH("Witch", EntityType.WITCH), 
    ZOMBIE("Zombie", EntityType.ZOMBIE), 
    ENDERDRAGON("Ender Dragon", EntityType.ENDER_DRAGON), 
    WITHER("Wither", EntityType.WITHER), 
    GIANT("Giant", EntityType.GIANT), 
    SILVERFISH("Silverfish", EntityType.SILVERFISH),
    PLAYER("Player", EntityType.PLAYER),
    SNOWMAN("Snowman", EntityType.SNOWMAN);

    private String name;
    private EntityType type;

    private Monsters(String name, EntityType type) { this.name = name;
      this.type = type; }

    public String getName()
    {
      return this.name;
    }

    public EntityType getType() {
      return this.type;
    }
  }
}