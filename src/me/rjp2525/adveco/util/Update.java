package me.rjp2525.adveco.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;
import me.rjp2525.adveco.AdvancedEco;

public class Update
{
  public File jar;
  public Logger log = Logger.getLogger("Minecraft");
  public AdvancedEco plugin;

  public Update(AdvancedEco instance)
  {
    this.plugin = instance;
  }

  protected int getVersion() {
    try {
      String[] split = this.plugin.getDescription().getVersion().split("\\.");
      return Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1]) * 10 + Integer.parseInt(split[2]);
    } catch (Exception localException) {
    }
    return -1;
  }

  public boolean checkUpdate() {
    try {
      URL versionfile = new URL("http://ae.ghostrage.com/version.txt");
      this.log.info("[AdvancedEco] Checking for updates..");
      BufferedReader in = new BufferedReader(new InputStreamReader(versionfile.openStream()));
      String str;
      while ((str = in.readLine()) != null)
      {
        String[] split = str.split("\\.");
        int version = Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1]) * 10 + Integer.parseInt(split[2]);
        if (version > getVersion()) {
          in.close();
          this.log.info(String.format("[AdvancedEco] Update found! http://bit.ly/advancedeco", new Object[] { Integer.valueOf(getVersion()), Integer.valueOf(version) }));
          return true;
        }
      }
      in.close();
    } catch (Exception e) {
      this.log.info("[AdvancedEco] An error has occurred while checking for updates");
      return false;
    }
    this.log.info("[AdvancedEco] No updates available.");
    return false;
  }

 
}