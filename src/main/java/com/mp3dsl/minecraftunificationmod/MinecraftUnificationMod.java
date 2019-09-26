package com.mp3dsl.minecraftunificationmod;

import com.mp3dsl.minecraftunificationmod.util.*;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = References.ACCEPTED_VERSIONS)
public class MinecraftUnificationMod
{
    private static Logger logger;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
    	Settings.load();
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	OreDict.getOres();
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Settings.save();
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
