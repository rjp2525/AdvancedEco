package me.rjp2525.adveco.listeners;

import me.rjp2525.adveco.config.MobExpConfig;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobExpListener
  implements Listener
{
  @EventHandler
  public void onEntityDeath(EntityDeathEvent event)
  {
	    if ((event.getEntity().getKiller() == null) || (!event.getEntity().getKiller().getType().equals(EntityType.PLAYER))) {
	      return;
	    }
	    if (event.getEntityType().equals(EntityType.SKELETON))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("skeleton"));
	    else if (event.getEntityType().equals(EntityType.ZOMBIE))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("zombie"));
	    else if (event.getEntityType().equals(EntityType.BLAZE))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("blaze"));
	    else if (event.getEntityType().equals(EntityType.CAVE_SPIDER))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("cavespider"));
	    else if (event.getEntityType().equals(EntityType.CHICKEN))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("chicken"));
	    else if (event.getEntityType().equals(EntityType.COW))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("cow"));
	    else if (event.getEntityType().equals(EntityType.CREEPER))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("creeper"));
	    else if (event.getEntityType().equals(EntityType.PIG))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("pig"));
	    else if (event.getEntityType().equals(EntityType.PIG_ZOMBIE))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("pigzombie"));
	    else if (event.getEntityType().equals(EntityType.ENDER_DRAGON))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("enderdragon"));
	    else if (event.getEntityType().equals(EntityType.ENDERMAN))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("enderman"));
	    else if (event.getEntityType().equals(EntityType.GHAST))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("ghast"));
	    else if (event.getEntityType().equals(EntityType.IRON_GOLEM))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("irongolem"));
	    else if (event.getEntityType().equals(EntityType.MAGMA_CUBE))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("magmacube"));
	    else if (event.getEntityType().equals(EntityType.MUSHROOM_COW))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("mushroomcow"));
	    else if (event.getEntityType().equals(EntityType.OCELOT))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("ocelot"));
	    else if (event.getEntityType().equals(EntityType.SILVERFISH))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("silverfish"));
	    else if (event.getEntityType().equals(EntityType.SLIME))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("slime"));
	    else if (event.getEntityType().equals(EntityType.SNOWMAN))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("snowman"));
	    else if (event.getEntityType().equals(EntityType.WOLF))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("wolf"));
	    else if (event.getEntityType().equals(EntityType.VILLAGER))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("villager"));
	    else if (event.getEntityType().equals(EntityType.SQUID))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("squid"));
	    else if (event.getEntityType().equals(EntityType.SPIDER))
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("spider"));
	    else if (event.getEntityType().equals(EntityType.GIANT)) {
	      event.setDroppedExp(MobExpConfig.xpconfig.getInt("giant"));
	    }

	  }
}