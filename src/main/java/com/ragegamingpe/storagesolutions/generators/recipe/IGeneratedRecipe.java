package com.ragegamingpe.storagesolutions.generators.recipe;

import net.minecraft.item.ItemStack;

// Shaped Recipe -> V = String[]
// Shapeless Recipe -> V = String
public interface IGeneratedRecipe<V>
{
    V getRecipeShape();

    void addItemStack(String key, ItemStack stack);
}
