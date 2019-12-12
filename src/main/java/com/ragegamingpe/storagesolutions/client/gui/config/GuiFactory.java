package com.ragegamingpe.storagesolutions.client.gui.config;

import com.ragegamingpe.storagesolutions.common.StorageSolutions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SideOnly(Side.CLIENT)
public class GuiFactory implements IModGuiFactory
{
    @Override
    public void initialize(Minecraft minecraftInstance)
    {

    }

    @Override
    public boolean hasConfigGui()
    {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parent)
    {
        return new ConfigScreen(parent);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    public static class ConfigScreen extends GuiConfig
    {
        public ConfigScreen(GuiScreen parent)
        {
            super(
                    parent,
                    getConfigElements(),
                    StorageSolutions.MODID,
                    false,
                    false,
                    StorageSolutions.NAME,
                    GuiConfig.getAbridgedConfigPath(StorageSolutions.config.toString())
            );
        }

        private static List<IConfigElement> getConfigElements()
        {
            List<IConfigElement> configElements = new ArrayList<>();
            for (String category : StorageSolutions.config.getCategoryNames()) {
                configElements.add(
                        new DummyConfigElement.DummyCategoryElement(
                                category,
                                "en_us",
                                new ConfigElement(StorageSolutions.config.getCategory(category)).getChildElements()
                        )
                );
            }

            return configElements;
        }
    }
}
