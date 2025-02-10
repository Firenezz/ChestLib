package com.dem.chestlib.api.database;

import java.util.UUID;

import com.google.common.collect.BiMap;

public interface IUuidDatabase<TValue> extends BiMap<UUID, TValue> {

}
