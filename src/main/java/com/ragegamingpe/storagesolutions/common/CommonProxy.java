package com.ragegamingpe.storagesolutions.common;

import com.ragegamingpe.storagesolutions.common.block.base.ModBlock;
import com.ragegamingpe.storagesolutions.common.config.Config;
import com.ragegamingpe.storagesolutions.common.item.base.ModItem;
import com.ragegamingpe.storagesolutions.common.lib.LibBlocks;
import com.ragegamingpe.storagesolutions.common.lib.LibItems;
import com.ragegamingpe.storagesolutions.common.network.GuiHandler;
import com.ragegamingpe.storagesolutions.common.network.MessageHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        StorageSolutions.config = new Config(event.getSuggestedConfigurationFile());

        NetworkRegistry.INSTANCE.registerGuiHandler(StorageSolutions.instance, new GuiHandler());
        MessageHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void init(FMLInitializationEvent event)
    {
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(LibBlocks.ALL_BLOCKS.toArray(new ModBlock[0]));
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        ItemBlock[] itemBlocks = new ItemBlock[LibBlocks.ALL_BLOCKS.size()];
        for (int i = 0; i < LibBlocks.ALL_BLOCKS.size(); i++) {
            ModBlock block = LibBlocks.ALL_BLOCKS.get(i);
            itemBlocks[i] = block.getItemBlock();
        }
        event.getRegistry().registerAll(itemBlocks);

        event.getRegistry().registerAll(LibItems.ALL_ITEMS.toArray(new ModItem[0]));
    }
}
