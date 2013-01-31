package me.rjp2525.adveco.listeners;

import me.rjp2525.adveco.AdvancedEco;
import me.rjp2525.adveco.config.MobMoneyMainConfig;
import me.rjp2525.adveco.util.Accounting;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PListener implements Listener {
	private AdvancedEco plugin;

	public PListener(AdvancedEco instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		double startingvalue = MobMoneyMainConfig.startingBalance;
		boolean hasAccount = Accounting.containsKey(player, AdvancedEco.accounts);

		if (!hasAccount) {
			Accounting.write(player, startingvalue, AdvancedEco.accounts);
			this.plugin.log("Account for player \"" + player.getName() + "\" was created!");
		}
	}
}