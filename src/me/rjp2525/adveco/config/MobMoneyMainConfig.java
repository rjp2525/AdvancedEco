package me.rjp2525.adveco.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import me.rjp2525.adveco.AdvancedEco;

public class MobMoneyMainConfig
{
  public static double startingBalance;
  public static String credit;
  public static String creditS;
  public static Boolean mmIsOn;
  public static Boolean MobExpIsOn;
  public static double bat;
  public static double chicken;
  public static double cow;
  public static double mooshroom;
  public static double ocelot;
  public static double pig;
  public static double sheep;
  public static double squid;
  public static double villager;
  public static double enderman;
  public static double wolf;
  public static double zombiepigman;
  public static double blaze;
  public static double cavespider;
  public static double creeper;
  public static double ghast;
  public static double magmacube;
  public static double silverfish;
  public static double skeleton;
  public static double slime;
  public static double spider;
  public static double witch;
  public static double zombie;
  public static double enderdragon;
  public static double wither;
  public static double giant;
  public static double player;
  public static double snowman;

  public static void loadMain()
  {
    String propertiesFile = AdvancedEco.mainDir + "config.yml";
    String mobPrices = AdvancedEco.mainDir + "mobprices.yml";
    PluginProperties properties = new PluginProperties(propertiesFile);
    PluginProperties propertiesC = new PluginProperties(mobPrices);
    File CFG = new File(propertiesFile);
    if (CFG.exists())
      try {
        properties.load(new FileInputStream(propertiesFile));
      } catch (IOException localIOException) {
      }
    File MP = new File(mobPrices);
    if (MP.exists())
      try {
        propertiesC.load(new FileInputStream(mobPrices));
      }
      catch (IOException localIOException1) {
      }
    startingBalance = properties.getDouble("Starting-Balance", 100.0D);
    credit = properties.getString("Currency-Plural", "Dollars");
    creditS = properties.getString("Currency-Singular", "Dollar");
    mmIsOn = properties.getBoolean("MobMoney-Is-On", new Boolean(false));
    MobExpIsOn = properties.getBoolean("MobExp-Is-On", new Boolean(false));
    bat = propertiesC.getDouble("Bat", 0.0D);
    chicken = propertiesC.getDouble("Chicken", 0.0D);
    cow = propertiesC.getDouble("Cow", 0.0D);
    mooshroom = propertiesC.getDouble("Mooshroom", 0.0D);
    ocelot = propertiesC.getDouble("Ocelot", 0.0D);
    pig = propertiesC.getDouble("Pig", 0.0D);
    sheep = propertiesC.getDouble("Sheep", 0.0D);
    squid = propertiesC.getDouble("Squid", 0.0D);
    villager = propertiesC.getDouble("Villager", 0.0D);
    enderman = propertiesC.getDouble("Enderman", 0.0D);
    wolf = propertiesC.getDouble("Wolf", 0.0D);
    zombiepigman = propertiesC.getDouble("ZombiePigman", 0.0D);
    blaze = propertiesC.getDouble("Blaze", 0.0D);
    cavespider = propertiesC.getDouble("CaveSpider", 0.0D);
    creeper = propertiesC.getDouble("Creeper", 0.0D);
    ghast = propertiesC.getDouble("Ghast", 0.0D);
    magmacube = propertiesC.getDouble("MagmaCube", 0.0D);
    skeleton = propertiesC.getDouble("Skeleton", 0.0D);
    slime = propertiesC.getDouble("Slime", 0.0D);
    spider = propertiesC.getDouble("Spider", 0.0D);
    witch = propertiesC.getDouble("Witch", 0.0D);
    zombie = propertiesC.getDouble("Zombie", 0.0D);
    enderdragon = propertiesC.getDouble("Enderdragon", 0.0D);
    wither = propertiesC.getDouble("Wither", 0.0D);
    giant = propertiesC.getDouble("Giant", 0.0D);
    silverfish = propertiesC.getDouble("Silverfish", 0.0D);
    player = propertiesC.getDouble("Player", 0.0D);
    snowman = propertiesC.getDouble("Snowman", 0.0D);
    properties.save("~~~AdvancedEco Config~~~\nStarting-Balance is how much money players start out with when they first join.\nCurrency is what the name of your currency will be.\nMobRewards-Is-On can be set to true or false. This will either turn mob rewards on or off. The server needs to be restarted if you change this.");
    propertiesC.save("~~~MobPrices Config~~~\nMob prices can be set to a negative number to take money away from a player or set to 0 to give no reward.");
  }
}