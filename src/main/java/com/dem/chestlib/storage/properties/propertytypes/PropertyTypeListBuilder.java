package com.dem.chestlib.storage.properties.propertytypes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.ResourceLocation;

import com.dem.chestlib.api.storage.INBTSaveLoad;

public class PropertyTypeListBuilder<TValue> {

    private ResourceLocation key;
    private List<TValue> defaultValue = new ArrayList<>();

    public PropertyTypeListBuilder<TValue> setKey(String key) {
        this.key = new ResourceLocation(key);
        return this;
    }

    public PropertyTypeListBuilder<TValue> setKey(ResourceLocation key) {
        this.key = key;
        return this;
    }

    public PropertyTypeListBuilder<TValue> setDefaultValue(List<TValue> defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public PropertyTypeList<TValue> createPropertyTypeList() {
        return new PropertyTypeList<>(key, defaultValue);
    }
}
