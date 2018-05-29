package test.com.nikita;

import com.nikita.HashMap.CollisionDetect.NoCollisionDetect;
import com.nikita.HashMap.CollisionDetect.OpenAddressing;
import com.nikita.HashMap.MyHashMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestForHashMapSize {
    MyHashMap<Integer, Long> hashMap = new MyHashMap<>(2);

    public void init() {
        for (int i = 0; i < 20; i++) {
            hashMap.put(i, (long)i*10);
        }
    }

    @Test
    public void testForSizeWithoutCollision() {
        hashMap.setBehavior(new NoCollisionDetect());
        init();
        assertEquals((long)this.hashMap.size(), 20);
    }

    @Test
    public void testForSizeWithCollisionWhenDuplicateKey() {
        hashMap.setBehavior(new NoCollisionDetect());
        init();
        hashMap.put(0, (long) 10); // ключ 0 присутствует, размер увеличится не должен
        assertEquals((long)this.hashMap.size(), 20);
    }

    @Test
    public void testForSizeWithoutCollisionWhenFakePut() {
        hashMap.setBehavior(new NoCollisionDetect());
        init();
        hashMap.fakePut(20, (long) 10, 3); // ключ 20 отсутствует и запись будт произведена
        // в ячейку ключа 3, коллизия не устранится и размер не увеличится
        assertEquals((long)this.hashMap.size(), 20);
    }

    @Test
    public void testForSizeWithCollisionWhenFakePut() {
        hashMap.setBehavior(new OpenAddressing());
        init();
        hashMap.fakePut(20, (long) 10, 3); // ключ 20 отсутствует и запись будт произведена
        // в ячейку ключа 3, коллизия устранится и размер увеличится
        assertEquals((long)this.hashMap.size(), 21);
    }
}

