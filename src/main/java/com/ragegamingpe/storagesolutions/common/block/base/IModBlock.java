package com.ragegamingpe.storagesolutions.common.block.base;

import com.ragegamingpe.storagesolutions.generators.recipe.IGeneratedRecipe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Functions used to register inventory rendering only. Has no effect on block rendering.
 */
public interface IModBlock
{
    /**
     * ModelHelper
     */
    @SideOnly(Side.CLIENT)
    void registerRender();

    /**
     * ModelBakery
     */
    @SideOnly(Side.CLIENT)
    default void registerModels()
    {

    }

    default String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Nullable
    default IGeneratedRecipe registerRecipe()
    {
        return null;
    }
}
