package test.com.nikita;

import com.nikita.Main;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Simple {

    @Test
    public void testHashMap() {
        Main app = new Main();
        assertEquals(app.testMap(1), "one");
        assertEquals(app.testMap(2), "two");
        assertEquals(app.testMap(3), "three");
    }

}
