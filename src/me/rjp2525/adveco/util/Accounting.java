package me.rjp2525.adveco.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.bukkit.entity.Player;

public class Accounting {
	public static boolean containsKey(Player p, File file) {
		Properties pro = new Properties();
		String player = p.getName();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			if (pro.containsKey(player))
				return true;
		} catch (IOException localIOException) {
		}
		return false;
	}

	public static void write(Player p, double startingBalance, File file) {
		Properties pro = new Properties();
		String startingvalue = new Double(startingBalance).toString();
		String player = p.getName();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			pro.setProperty(player, startingvalue);
			pro.store(new FileOutputStream(file), null);
		} catch (IOException localIOException) {
		}
	}

	public static double getBalance(Player p, File file) {
		Properties pro = new Properties();
		String player = p.getName();
		try {
			FileInputStream in = new FileInputStream(file);
			pro.load(in);
			String string = pro.getProperty(player);
			return Double.parseDouble(string);
		} catch (IOException localIOException) {
		}
		return 0.0D;
	}
}