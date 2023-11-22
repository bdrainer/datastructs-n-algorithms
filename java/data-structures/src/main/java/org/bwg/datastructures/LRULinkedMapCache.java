package org.bwg.datastructures;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Use a LinkedHashMap to remove the item that has not been accessed as recently as all other items in the cached.  The
 * cache is given a max size.  When an item is added causing the cache to exceed the max the item that was least
 * recently accessed is evicted.
 *
 * @param <K>
 * @param <V>
 */
public class LRULinkedMapCache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_ENTRIES = 5;

    public LRULinkedMapCache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
