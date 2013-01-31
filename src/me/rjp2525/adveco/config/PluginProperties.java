package me.rjp2525.adveco.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PluginProperties extends Properties {
	static final long serialVersionUID = 1L;
	private String fileName;

	public PluginProperties(String file) {
		this.fileName = file;
	}

	public void load() {
		File file = new File(this.fileName);
		if (file.exists())
			try {
				load(new FileInputStream(this.fileName));
			} catch (IOException localIOException) {
			}
	}

	public void save(String start) {
		try {
			store(new FileOutputStream(this.fileName), start);
		} catch (IOException localIOException) {
		}
	}
	
	public int getInteger(String key, int value) {
	    if (containsKey(key)) {
	      return Integer.parseInt(getProperty(key));
	    }
	    put(key, String.valueOf(value));
	    return value;
	  }

	public double getDouble(String key, double value) {
		if (containsKey(key)) {
			return Double.parseDouble(getProperty(key));
		}

		put(key, String.valueOf(value));
		return value;
	}

	public String getString(String key, String value) {
		if (containsKey(key)) {
			return getProperty(key);
		}

		put(key, value);
		return value;
	}

	public Boolean getBoolean(String key, Boolean value) {
		if (containsKey(key)) {
			return Boolean.valueOf(Boolean.parseBoolean(getProperty(key)));
		}

		put(key, String.valueOf(value));
		return value;
	}
}