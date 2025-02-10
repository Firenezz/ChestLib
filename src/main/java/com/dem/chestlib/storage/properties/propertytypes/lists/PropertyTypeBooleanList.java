package com.dem.chestlib.storage.properties.propertytypes.lists;

import com.dem.chestlib.storage.properties.propertytypes.PropertyTypeList;
import com.dem.chestlib.util.nbt.NBTReaderUtil;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class PropertyTypeBooleanList extends PropertyTypeList<Boolean> {
    public PropertyTypeBooleanList(ResourceLocation key, List<Boolean> defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public List<Boolean> readValue(NBTBase nbt) {
        return NBTReaderUtil.readList(nbt, NBTReaderUtil::readBooleanValue).orElse(this.getDefault());
    }

    @Override
    public NBTBase writeValue(List<Boolean> value) {
        return null;
    }
}
