package me.rjp2525.adveco.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.rjp2525.adveco.AdvancedEco;
import me.rjp2525.adveco.config.PluginProperties;

public class MobExpConfig
{
    public static int bat;
    public static int chicken;
    public static int cow;
    public static int mooshroom;
    public static int ocelot;
    public static int pig;
    public static int sheep;
    public static int squid;
    public static int villager;
    public static int enderman;
    public static int wolf;
    public static int zombiepigman;
    public static int blaze;
    public static int cavespider;
    public static int creeper;
    public static int ghast;
    public static int magmacube;
    public static int silverfish;
    public static int skeleton;
    public static int slime;
    public static int spider;
    public static int witch;
    public static int zombie;
    public static int enderdragon;
    public static int wither;
    public static int giant;
    public static int snowman;
    public static int player;
	public static FileConfiguration xpconfig;
	static File mconfig = new File(AdvancedEco.mainDir, "mobexp.yml");

  public static void loadMain()
  {
    String propertiesFile = AdvancedEco.mainDir + "mobexp.yml";
    PluginProperties propertiesE = new PluginProperties(propertiesFile);
    File EXPCFG = new File(propertiesFile);
    if (EXPCFG.exists())
      try {
        propertiesE.load(new FileInputStream(propertiesFile));
        xpconfig = YamlConfiguration.loadConfiguration(mconfig);
      } catch (IOException localIOException) {
      }

    bat = propertiesE.getInteger("Bat", 0);
    chicken = propertiesE.getInteger("Chicken", 0);
    cow = propertiesE.getInteger("Cow", 0);
    mooshroom = propertiesE.getInteger("Mooshroom", 0);
    ocelot = propertiesE.getInteger("Ocelot", 0);
    pig = propertiesE.getInteger("Pig", 0);
    sheep = propertiesE.getInteger("Sheep", 0);
    squid = propertiesE.getInteger("Squid", 0);
    villager = propertiesE.getInteger("Villager", 0);
    enderman = propertiesE.getInteger("Enderman", 0);
    wolf = propertiesE.getInteger("Wolf", 0);
    zombiepigman = propertiesE.getInteger("ZombiePigman", 0);
    blaze = propertiesE.getInteger("Blaze", 0);
    cavespider = propertiesE.getInteger("CaveSpider", 0);
    creeper = propertiesE.getInteger("Creeper", 0);
    ghast = propertiesE.getInteger("Ghast", 0);
    magmacube = propertiesE.getInteger("MagmaCube", 0);
    skeleton = propertiesE.getInteger("Skeleton", 0);
    slime = propertiesE.getInteger("Slime", 0);
    spider = propertiesE.getInteger("Spider", 0);
    witch = propertiesE.getInteger("Witch", 0);
    zombie = propertiesE.getInteger("Zombie", 0);
    enderdragon = propertiesE.getInteger("Enderdragon", 0);
    wither = propertiesE.getInteger("Wither", 0);
    giant = propertiesE.getInteger("Giant", 0);
    silverfish = propertiesE.getInteger("Silverfish", 0);
    snowman = propertiesE.getInteger("Snowman", 0);
    player = propertiesE.getInteger("Player", 0);

    propertiesE.save("~~~AdvancedEco Mob EXP Drop Config~~~\nChange any of the values below to change the amount of EXP mobs drop, make sure it's enabled in config.yml!");
  }
}