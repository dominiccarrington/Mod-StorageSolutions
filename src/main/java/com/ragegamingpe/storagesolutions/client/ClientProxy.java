package com.ragegamingpe.storagesolutions.client;

import com.ragegamingpe.storagesolutions.common.CommonProxy;
import com.ragegamingpe.storagesolutions.common.block.base.IModBlock;
import com.ragegamingpe.storagesolutions.common.item.base.IModItem;
import com.ragegamingpe.storagesolutions.common.lib.LibBlocks;
import com.ragegamingpe.storagesolutions.common.lib.LibItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        LibBlocks.ALL_BLOCKS.forEach(IModBlock::registerModels);
        LibItems.ALL_ITEMS.forEach(IModItem::registerModels);

        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        LibBlocks.ALL_BLOCKS.forEach(IModBlock::registerRender);
        LibItems.ALL_ITEMS.forEach(IModItem::registerRender);
    }
}
