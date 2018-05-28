package test.com.nikita;

import com.nikita.HashMap.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Simple {
    MyHashMap<Integer, Long> hashMap = new MyHashMap<>(365);

    @Before
    public void init() {
        this.hashMap.put(1, (long)10);
        this.hashMap.put(2, (long)40);
        this.hashMap.put(3, (long)30);
    }
    @Test(timeout = 1)
    public void testForTimeoutGet() {
        assertEquals((long)this.hashMap.get(1), 10);
    }
}
