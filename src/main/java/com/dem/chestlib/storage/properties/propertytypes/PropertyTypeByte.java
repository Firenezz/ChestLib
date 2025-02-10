package com.dem.chestlib.storage.properties.propertytypes;

import com.dem.chestlib.util.nbt.NBTReaderUtil;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.util.ResourceLocation;

public class PropertyTypeByte extends PropertyTypeBase<Byte> {

    public PropertyTypeByte(ResourceLocation key, Byte defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Byte readValue(NBTBase nbt) {
        return NBTReaderUtil.readByteValue(nbt).orElse(this.getDefault());
    }

    @Override
    public NBTBase writeValue(Byte value) {
        if (value == null) {
            return new NBTTagByte(this.getDefault());
        }

        return new NBTTagByte(value);
    }
}
