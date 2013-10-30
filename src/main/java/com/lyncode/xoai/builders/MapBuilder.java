package com.lyncode.xoai.builders;

import java.util.Map;
import java.util.TreeMap;

public class MapBuilder<K, V> {
    private Map<K, V> map = new TreeMap<K, V>();

    public MapBuilder withPair (K key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<K, V> build () {
        return this.map;
    }
}