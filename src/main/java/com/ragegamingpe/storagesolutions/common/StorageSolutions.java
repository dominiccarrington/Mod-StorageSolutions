package com.ragegamingpe.storagesolutions.common;

import com.ragegamingpe.storagesolutions.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = StorageSolutions.MODID, name = StorageSolutions.NAME, version = StorageSolutions.VERSION, dependencies = StorageSolutions.DEPENDENCIES, guiFactory = StorageSolutions.CONFIG_GUI)
public class StorageSolutions
{
    public static final String MODID = "storagesolutions";
    public static final String NAME = "Storage Solutions";
    public static final String VERSION = "GRADLE:VERSION";
    public static final String DEPENDENCIES = "";
    public static final String CONFIG_GUI = "com.ragegamingpe.storagesolutions.client.gui.config.GuiFactory";

    public static Logger logger;

    @Mod.Instance
    public static StorageSolutions instance;

    @SidedProxy(
            clientSide = "com.ragegamingpe.storagesolutions.client.ClientProxy",
            serverSide = "com.ragegamingpe.storagesolutions.common.CommonProxy"
    )
    private static CommonProxy proxy;

    public static Config config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    private String enabledOrDisabled(boolean b)
    {
        return b ? "Enabled" : "Disabled";
    }
}