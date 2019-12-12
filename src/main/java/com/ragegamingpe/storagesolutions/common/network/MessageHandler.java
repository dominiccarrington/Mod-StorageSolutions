package com.ragegamingpe.storagesolutions.common.network;

import com.ragegamingpe.storagesolutions.common.StorageSolutions;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class MessageHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(StorageSolutions.MODID);

    private static int i = 0;

    public static void init()
    {
    }

    @SuppressWarnings("unchecked")
    private static void register(Class clazz, Side handlerSide)
    {
        INSTANCE.registerMessage(clazz, clazz, i++, handlerSide);
    }
}
