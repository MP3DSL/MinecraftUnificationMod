package com.mp3dsl.minecraftunificationmod.util;

import java.util.ArrayList;

public class References
{

	public static final String MODID = "mum";
    public static final String NAME = "Minecraft Unification Mod";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "com.mp3dsl.unification.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.mp3dsl.unification.proxy.CommonProxy";
    public static final String CONFIG_VERSION = "1.0";
    
    public static String[] defaultPrefix = {"ore", "dust", "ingot", "block", "nugget", "dye", "gear", "gem", "rod", "plate", "chunk", "dustTiny", "dustSmall"};
    public static String[] searchPrefix = defaultPrefix;
    public static String[] defaultSuffix = {"Iron", "Gold", "Copper", "Tin", "Silver", "Lead", "Nickel", "Platinum", "Zinc", "Aluminium", "Aluminum", "Alumina", "Chromium", "Chrome", "Uranium", "Iridium", "Osmium", "Bronze", "Steel", "Brass", "Invar", "Electrum", "Cupronickel", "Constantan", "Ruby", "Sapphire", "Peridot", "RefinedIron"};
    public static String[] searchSuffix = defaultSuffix;
    public static String[] defaultPreferedModIDList = {};
    public static ArrayList <String> generatedModIDList = new ArrayList<String>();
    public static String[] preferedModIDList = defaultPreferedModIDList;
	
}
