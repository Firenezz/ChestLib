package com.dem.chestlib.storage.properties.propertytypes;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.ResourceLocation;

public class PropertyTypeCompound<T> extends PropertyTypeBase<T> {

    public PropertyTypeCompound(ResourceLocation key, T defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public T readValue(NBTBase nbt) {
        return null;
    }

    @Override
    public NBTBase writeValue(T value) {
        return null;
    }
}
