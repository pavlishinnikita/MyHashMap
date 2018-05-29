package test.com.nikita;

import com.nikita.SimpleHashMap.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Simple {
    MyHashMap<Integer, Long> hashMap = new MyHashMap<>();

    @Before
    public void init() {
        for (int i = 0; i < 20; i++) {
            hashMap.put(i, (long)i*10);
        }
    }

    @Test(timeout = 1)
    public void testForTimeoutGet() {
        assertEquals((long)this.hashMap.get(1), 10);
    }

    @Test
    public void testForGet() {
        for (int i = 0; i < 20; i++) {
            assertEquals((long)this.hashMap.get(i), (long)i*10);
        }
    }
}
