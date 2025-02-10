package com.dem.chestlib.storage.properties.propertytypes;

import java.util.*;
import java.util.function.Function;

import com.dem.chestlib.util.nbt.NBTReaderUtil;
import com.dem.chestlib.util.nbt.NBTTagUtil;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

/// Not ready yet
public class PropertyTypeList<TValue> extends PropertyTypeBase<List<TValue>> {

    private final Class<TValue> valueType;

    @SuppressWarnings("unchecked")
    public PropertyTypeList(ResourceLocation key, List<TValue> defaultValue) {
        super(key, defaultValue);
        assert !defaultValue.isEmpty() : "The default list must be non-empty to get the class. Use the other constructor to manually set the class";

        this.valueType = (Class<TValue>) defaultValue.get(0).getClass();
    }

    public PropertyTypeList(ResourceLocation key, List<TValue> defaultValue, Class<TValue> valueType) {
        super(key, defaultValue);
        this.valueType = valueType;

    }

    private static final Map<String, Function<NBTBase, Optional>> PROCESSORS = Map.of(
        Byte.class.getName(), NBTReaderUtil::readByteValue,
        Boolean.class.getName(), NBTReaderUtil::readBooleanValue
    );

    private static final String BYTE = Byte.class.getName();
    private static final String BOOLEAN = Byte.class.getName();

    @Override
    @SuppressWarnings("unchecked")
    public List<TValue> readValue(final NBTBase nbt) {
        if (!(nbt instanceof NBTTagList nbtList)){
            return this.getDefault();
        }

        try {
            String name = valueType.getName();

            var function = PROCESSORS.get(name);

            return NBTReaderUtil
                .readList(nbtList, (nbtElement) -> (Optional<TValue>)function.apply(nbtElement))
                .orElse(this.getDefault());
        } catch (Exception e) {
            return this.getDefault();
        }
    }

    @Override
    public NBTBase writeValue(final List<TValue> value) {
        return null;
    }
}
