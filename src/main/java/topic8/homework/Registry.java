package topic8.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Registry<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public boolean add(K key, V value) {
        if (map.containsKey(key)) {
            return false;
        }
        map.put(key, value);
        return true;
    }

    public V get(K key) {
        return map.get(key);
    }

    boolean containsKey(K key){
        return map.containsKey(key);
    }

    public V remove(K key) {
        return map.remove(key);
    }

    Collection<V> values(){
        return map.values();
    }
}
