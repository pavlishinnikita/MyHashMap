package test.com.nikita;

import com.nikita.SimpleHashMap.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestForSimpleHashMapSize {
    MyHashMap<Integer, Long> hashMap = new MyHashMap<>(2);

    @Before
    public void init() {
        for (int i = 0; i < 20; i++) {
            hashMap.put(i, (long)i*10);
        }
    }

    @Test
    public void testForSizeWithoutCollision() {
        assertEquals((long)this.hashMap.size(), 20);
    }

    @Test
    public void testForSizeWithCollisionWhenDuplicateKey() {
        hashMap.put(0, (long) 10); // ключ 0 присутствует, размер увеличится не должен
        assertEquals((long)this.hashMap.size(), 20);
    }

    @Test
    public void testForSizeWithCollisionWhenFakePut() {
        hashMap.fakePut(20, (long) 10, 3); // ключ 20 отсутствует и запись будт произведена
        // в ячейку ключа 3, коллизия устранится и размер увеличится
        assertEquals((long)this.hashMap.size(), 21);
    }
}
