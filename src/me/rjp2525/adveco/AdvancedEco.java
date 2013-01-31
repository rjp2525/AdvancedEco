package me.rjp2525.adveco;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import me.rjp2525.adveco.config.MobExpConfig;
import me.rjp2525.adveco.config.MobMoneyMainConfig;
import me.rjp2525.adveco.listeners.CommandClass;
import me.rjp2525.adveco.listeners.MobMoneyListener;
import me.rjp2525.adveco.listeners.PListener;
import me.rjp2525.adveco.util.Metrics;
import me.rjp2525.adveco.util.Update;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancedEco extends JavaPlugin {
	CommandClass executor = new CommandClass(null);
	static String updDir = "plugins";
	public static String mainDir = "plugins" + File.separator + "AdvancedEco" + File.separator;
	public static File accounts = new File(mainDir + "players.accounts");
	private final PListener pListener = new PListener(this);
	private MobMoneyListener mListener;
	public static Permission permission;
	private final Update updateManager = new Update(this);

	public void onEnable() {
		if (setupPermissions()) {
			log("Hooked into Vault!");
		} else {
			log("Could not find Vault! Shutting down!");
			setEnabled(false);
		}

	    new File(mainDir).mkdir();
	    if (!accounts.exists())
	      try {
	        accounts.createNewFile();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    
	    MobMoneyMainConfig.loadMain();
	    MobExpConfig.loadMain();
	    
	    this.updateManager.checkUpdate();

		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(this.pListener, this);

		if (MobMoneyMainConfig.mmIsOn.booleanValue()) {
			this.mListener = new MobMoneyListener();
			pm.registerEvents(this.mListener, this);
		}

		getCommand("money").setExecutor(this.executor);
		

		log("Plugin is enabled!");
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		}
	}

	public void onDisable() {
		log("Plugin is disabled!");
	}
	
	  public File fileGet() {
		    return getFile();
		  }

	public void log(String msg) {
		PluginDescriptionFile pdfile = getDescription();
		Logger.getLogger("AdvancedEco").info("[AdvancedEco] v(" + pdfile.getVersion() + "): " + msg);
	}

	public static String pMsg(String msg) {
		return ChatColor.GREEN + msg;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = getServer()
				.getServicesManager().getRegistration(Permission.class);

		if (permissionProvider != null) {
			permission = (Permission) permissionProvider.getProvider();
		}

		return permission != null;
	}
}
