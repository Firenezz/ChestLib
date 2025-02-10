package com.dem.chestlib.util.nbt;

import com.dem.chestlib.api.storage.INBTSaveLoad;
import com.dem.chestlib.storage.properties.propertytypes.PropertyTypeBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class NBTReaderUtil {
    public static Optional<Byte> readByteValue(NBTBase nbt) {
        if (!(nbt instanceof NBTBase.NBTPrimitive) || nbt.getId() != PropertyTypeBase.BYTE_TAG) {
            return Optional.empty();
        }

        return Optional.of(((NBTBase.NBTPrimitive) nbt).func_150290_f());
    }

    public static Optional<Boolean> readBooleanValue(NBTBase nbt) {
        if (nbt == null || nbt.getId() < 1 || nbt.getId() > 6) {
            return Optional.empty();
        }

        try {
            return Optional.of(((NBTBase.NBTPrimitive) nbt).func_150290_f() > 0);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static <T extends INBTSaveLoad<NBTTagCompound>> Optional<NBTTagCompound> readCompound(NBTBase nbt) {
        if (nbt == null || nbt.getId() != PropertyTypeBase.COMPOUND_TAG) {
            return Optional.empty();
        }

        try {
            return Optional.of(((NBTBase.NBTPrimitive) nbt).func_150290_f() > 0);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static <T> Optional<List<T>> readList(NBTBase nbt, Function<NBTBase, Optional<T>> processor) {
        if (!(nbt instanceof NBTTagList nbtTagList)) {
            return Optional.empty();
        }

        try{
            return Optional.of(NBTTagUtil.readListOfNBT(nbtTagList).stream()
                .map((nbtElement) -> processor.apply(nbtElement).orElseThrow())
                .toList());
        } catch (Throwable e) {
            return Optional.empty();
        }
    }
}
