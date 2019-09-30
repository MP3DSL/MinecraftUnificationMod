package com.mp3dsl.minecraftunificationmod;

import com.mp3dsl.minecraftunificationmod.proxy.CommonProxy;
import com.mp3dsl.minecraftunificationmod.util.*;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = References.ACCEPTED_VERSIONS)
public class MinecraftUnificationMod
{
    private static Logger logger;
    
    @SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    
    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
    	Settings.load();
    }
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	OreDict.getOres();
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
    	Settings.save();
    }
}
