package com.mp3dsl.minecraftunificationmod.util;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

/**
 * 
 * @author MP3DSL
 *
 */
public class Settings {
	
	public static Configuration configuration = new Configuration(new File(Minecraft.getMinecraft().mcDataDir, "/config/mum/preferences.cfg"), References.CONFIG_VERSION);

	public static void load()
	{
		System.out.println(configuration.getDefinedConfigVersion());
		configuration.load();
		System.out.println(configuration.getLoadedConfigVersion());
		References.searchPrefix = configuration.getStringList("Types of Items", "Item Preferences", References.defaultPrefix, "Add or remove oreDict types of item you want unified.");
		References.searchSuffix = configuration.getStringList("Material of Items", "Item Preferences", References.defaultSuffix, "Add or remove oreDict material of item you want unified.");
	}
	
	public static void save()
	{
		configuration.save();
	}

}
