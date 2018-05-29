package test.com.nikita;


import com.nikita.HashMap.CollisionDetect.NoCollisionDetect;
import com.nikita.HashMap.CollisionDetect.OpenAddressing;
import com.nikita.HashMap.MyHashMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestForHashMapGet {
    MyHashMap<Integer, Long> hashMap = new MyHashMap<>(2);
    private int countElements = 10;

    public void init() {
        for (int i = 0; i < countElements; i++) {
            hashMap.put(i, (long)i*10);
        }
    }

    @Test
    public void testForGetWithoutCollision() {
        hashMap.setBehavior(new NoCollisionDetect());
        init();
        for (int i = 0; i < countElements; i++) {
            assertEquals((long)hashMap.get(i), (long)10 * i);
        }
    }

    @Test
    public void testForGetWithoutCollisionWhenDuplicateKey() {
        hashMap.setBehavior(new NoCollisionDetect());
        init();
        hashMap.put(7, (long) 10); // ключ 7 присутствует - произойдет перезапись
        for (int i = 0; i < countElements; i++) {
            if(i == 7) {
                assertEquals((long)hashMap.get(i), (long)10);
            } else {
                assertEquals((long)hashMap.get(i), (long)10 * i);
            }
        }
    }

    @Test
    public void testForGetWithCollisionWhenDuplicateKey() {
        hashMap.setBehavior(new OpenAddressing());
        init();
        hashMap.put(7, (long) 10); // ключ 7 присутствует - произойдет перезапись
        for (int i = 0; i < countElements; i++) {
            if(i == 7) {
                assertEquals((long)hashMap.get(i), (long)10);
            } else {
                assertEquals((long)hashMap.get(i), (long)10 * i);
            }
        }
    }

    @Test
    public void testForGetWithCollisionWhenFakePut() {
        hashMap.setBehavior(new OpenAddressing());
        init();
        hashMap.fakePut(20, (long) 200, 3); // запись будет произведена в ячейку ключа 3
        assertEquals((long)hashMap.get(3), (long)3*10);
        assertEquals((long)hashMap.get(20), (long)200);
    }
}
