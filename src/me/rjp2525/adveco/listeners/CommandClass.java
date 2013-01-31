package me.rjp2525.adveco.listeners;

import java.util.List;

import me.rjp2525.adveco.AdvancedEco;
import me.rjp2525.adveco.config.MobMoneyMainConfig;
import me.rjp2525.adveco.util.Accounting;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor {
	AdvancedEco plugin;

	public CommandClass(AdvancedEco instance) {
		this.plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] split) {
		Player player = (Player) sender;

		
		if ((cmd.getName().equalsIgnoreCase("money")) && (split.length == 0)) {
			if (AdvancedEco.permission.playerHas(player, "AdvancedEco.user")) {
				double balance = Accounting.getBalance(player, AdvancedEco.accounts);
				player.sendMessage(AdvancedEco.pMsg("Your balance is " + String.valueOf(balance) + " " + MobMoneyMainConfig.credit));
				return true;
			}

			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "You do not have permission to use this command."));
			return true;
		}

		if ((cmd.getName().equalsIgnoreCase("money")) && (split.length == 3)) {
			if (split[0].equalsIgnoreCase("pay")) {
				if (AdvancedEco.permission.playerHas(player, "AdvancedEco.pay")) {
					userPay(player, split);
					return true;
				}
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "You do not have permission to use this command."));
				return true;
			}

			if (split[0].equalsIgnoreCase("give")) {
				if (AdvancedEco.permission.playerHas(player, "AdvancedEco.give")) {
					userGive(player, split);
					return true;
				}
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "You do not have permission to use this command."));
				return true;
			}

			if (split[0].equalsIgnoreCase("set")) {
				if (AdvancedEco.permission.playerHas(player, "AdvancedEco.set")) {userSet(player, split);
					return true;
				}
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "You do not have permission to use this command."));
				return true;
			}

			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Invalid arguments. Type \"/money help\" for more info."));
			return true;
		}

		if ((cmd.getName().equalsIgnoreCase("money")) && (split.length == 1)) {
			if (split[0].equalsIgnoreCase("help")) {
				if (AdvancedEco.permission.playerHas(player, "AdvancedEco.user")) {
					userHelp(player);
					return true;
				}
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "You do not have permission to use this command!"));
				return true;
			}

			if (split[0].equalsIgnoreCase("reload")) {
				if (AdvancedEco.permission.playerHas(player,"AdvancedEco.reload")) {
					reloadPlugin(player);
					return true;
				}
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "You do not have permission to use this command!"));
				return true;
			}

			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Invalid arguments. Type \"/money help\" for more info."));
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("money")) {
			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Invalid arguments. Type \"/money help\" for more info."));
			return true;
		}

		return false;
	}

	private void userHelp(Player player) {
		player.sendMessage(AdvancedEco.pMsg("/money"));
		player.sendMessage(AdvancedEco.pMsg("/money pay (user) (amount)"));
		player.sendMessage(AdvancedEco.pMsg("/money give (user) (amount)"));
		player.sendMessage(AdvancedEco.pMsg("/money set (user) (amount)"));
		player.sendMessage(AdvancedEco.pMsg("/money reload"));
		player.sendMessage(AdvancedEco.pMsg("/money help"));
	}

	private void userSet(Player player, String[] split) {
		try {
			String toPlayer = split[1];
			double amount = Double.parseDouble(split[2]);
			List<?> players = this.plugin.getServer().matchPlayer(toPlayer);

			if (players.size() == 0) {
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Player not found"));
				return;
			}
			if (players.size() != 1) {
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Enter full username"));
				return;
			}
			Player reciever = (Player) players.get(0);
			boolean toHasAccount = Accounting.containsKey(reciever, AdvancedEco.accounts);
			if ((toHasAccount) && (amount >= 0.0D)) {
				Accounting.write(reciever, amount, AdvancedEco.accounts);
				if ((amount > 0.0D) && (amount <= 1.0D)) {
					player.sendMessage(AdvancedEco.pMsg("You set " + reciever.getName() + "'s balance to " + String.valueOf(amount) + " " + MobMoneyMainConfig.creditS));
					reciever.sendMessage(AdvancedEco.pMsg("Your account balance was set to " + String.valueOf(amount) + " " + MobMoneyMainConfig.creditS));
				} else {
					player.sendMessage(AdvancedEco.pMsg("You set " + reciever.getName() + "'s balance to " + String.valueOf(amount) + " " + MobMoneyMainConfig.creditS));
					reciever.sendMessage(AdvancedEco.pMsg("Your account balance was set to " + String.valueOf(amount) + " " + MobMoneyMainConfig.creditS));
				}

				return;
			}

			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Player does not exist or you entered a negative amount"));
			return;
		} catch (Exception e) {
			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Invalid Amount"));
		}
	}

	private void userPay(Player player, String[] split) {
		String toPlayer = split[1];
		double balance = Accounting.getBalance(player, AdvancedEco.accounts);
		try {
			double amount = Double.parseDouble(split[2]);

			List<?> playerr = this.plugin.getServer().matchPlayer(toPlayer);

			if (playerr.size() == 0) {
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Player not found"));
				return;
			}
			if (playerr.size() != 1) {
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Enter full username"));
				return;
			}
			Player reciever = (Player) playerr.get(0);
			boolean toHasAccount = Accounting.containsKey(reciever, AdvancedEco.accounts);
			if ((toHasAccount) && (balance >= amount) && (amount > 0.0D)) {
				double newBalance = balance - amount;
				Accounting.write(player, newBalance, AdvancedEco.accounts);
				double toBalance = Accounting.getBalance(reciever, AdvancedEco.accounts);
				double newToBalance = toBalance + amount;
				Accounting.write(reciever, newToBalance, AdvancedEco.accounts);

				if (((amount > 0.0D) && (amount <= 1.0D))
						|| ((amount < 0.0D) && (amount >= -1.0D))) {
					player.sendMessage(AdvancedEco.pMsg("You paid " + toPlayer + " " + String.valueOf(amount) + " " + MobMoneyMainConfig.creditS));
					reciever.sendMessage(AdvancedEco.pMsg(player.getName() + " has sent you " + amount + " " + MobMoneyMainConfig.creditS));
				} else {
					player.sendMessage(AdvancedEco.pMsg("You paid " + toPlayer + " " + String.valueOf(amount) + " " + MobMoneyMainConfig.credit));
					reciever.sendMessage(AdvancedEco.pMsg(player.getName() + " has sent you " + amount + " " + MobMoneyMainConfig.credit));
				}

				return;
			}
			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: You do not have enough money or that player does not exist"));
			return;
		} catch (Exception e) {
			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Invalid amount"));
		}
	}

	private void userGive(Player player, String[] split) {
		String toPlayer = split[1];
		try {
			double amount = Double.parseDouble(split[2]);
			List<?> playerr = this.plugin.getServer().matchPlayer(toPlayer);

			if (playerr.size() == 0) {
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Player not found"));
				return;
			}
			if (playerr.size() != 1) {
				player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Enter full username"));
				return;
			}
			Player reciever = (Player) playerr.get(0);
			boolean toHasAccount = Accounting.containsKey(reciever, AdvancedEco.accounts);
			if ((toHasAccount) && (amount > 0.0D)) {
				double toBalance = Accounting.getBalance(reciever, AdvancedEco.accounts);
				double newToBalance = toBalance + amount;
				Accounting.write(reciever, newToBalance, AdvancedEco.accounts);

				if ((amount > 0.0D) && (amount <= 1.0D)) {
					player.sendMessage(AdvancedEco.pMsg(amount + " " + MobMoneyMainConfig.creditS + " has been transfered to " + toPlayer));
					reciever.sendMessage(AdvancedEco.pMsg(player.getName() + " gave you " + amount + " " + MobMoneyMainConfig.creditS));
				} else {
					player.sendMessage(AdvancedEco.pMsg(amount + " " + MobMoneyMainConfig.credit + " has been transfered to " + toPlayer));
					reciever.sendMessage(AdvancedEco.pMsg(player.getName() + " gave you " + amount + " " + MobMoneyMainConfig.credit));
				}

				return;
			}
			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Player does not exist or you entered a negative amount"));
			return;
		} catch (Exception e) {
			player.sendMessage(AdvancedEco.pMsg(ChatColor.RED + "Error: Invalid amount"));
		}
	}

	private void reloadPlugin(Player player) {
		MobMoneyMainConfig.loadMain();
		player.sendMessage(AdvancedEco.pMsg("AdvancedEco Configuration Reloaded"));
	}
}