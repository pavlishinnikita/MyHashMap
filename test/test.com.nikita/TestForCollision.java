package test.com.nikita;
import com.nikita.HashMap.CollisionDetect.NoCollisionDetect;
import com.nikita.HashMap.CollisionDetect.OpenAddressing;
import com.nikita.HashMap.MyHashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestForCollision {
    MyHashMap<Integer, Long> hashMap = new MyHashMap<>(1);

    @Before
    public void init() {
        hashMap.setBehavior(new OpenAddressing());
        for(int i = 0; i < 10; i++) {
            hashMap.put(i, (long)i * 10);
        }
    }

    @Test(timeout = 1)
    public void testForTimeoutGet() {
        hashMap.setBehavior(new NoCollisionDetect());
        assertEquals((long)this.hashMap.get(0), 0);
    }

    @Test
    public void testForNoDetectCollision() {
        hashMap.setBehavior(new NoCollisionDetect());
        for(int i = 0; i < 10; i++) {
                assertEquals((long)this.hashMap.get(i), i*10);
        }
        hashMap.fakePut(0, (long)777, 9);
        assertEquals((long)this.hashMap.get(9), 777); // because pushed key = 0 value = 777,
        // but key was change to 9
    }

    @Test
    public void testForOpenAddressing() {
        hashMap.setBehavior(new OpenAddressing());
        hashMap.fakePut(0, (long)999, 3);
        for(int i = 0; i < 10; i++) {
            assertEquals((long)this.hashMap.get(i), i*10);
        }
    }
}
