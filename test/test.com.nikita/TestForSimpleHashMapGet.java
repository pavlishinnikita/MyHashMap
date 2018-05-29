package test.com.nikita;

import com.nikita.SimpleHashMap.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestForSimpleHashMapGet {
    MyHashMap<Integer, Long> hashMap = new MyHashMap<>(2);
    private int countElements = 10;
    @Before
    public void init() {
        for (int i = 0; i < countElements; i++) {
            hashMap.put(i, (long)i*10);
        }
    }

    @Test(timeout = 1)
    public void testForGetWithoutCollision() {
        for (int i = 0; i < countElements; i++) {
            assertEquals((long)hashMap.get(i), (long)10 * i);
        }
    }

    @Test(timeout = 1)
    public void testForGetWithCollisionWhenDuplicateKey() {
        hashMap.put(7, (long) 10); // ключ 7 присутствует - произойдет перезапись
        for (int i = 0; i < countElements; i++) {
            if(i == 7) {
                assertEquals((long)hashMap.get(i), (long)10);
            } else {
                assertEquals((long)hashMap.get(i), (long)10 * i);
            }
        }
    }

    @Test(timeout = 1)
    public void testForGetWithCollisionWhenFakePut() {
        hashMap.fakePut(20, (long) 200, 3); // запись будет произведена в ячейку ключа 3
        assertEquals((long)hashMap.get(3), (long)3*10);
        assertEquals((long)hashMap.get(20), (long)200);
    }
}
