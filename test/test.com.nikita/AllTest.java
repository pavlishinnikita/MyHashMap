package test.com.nikita;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestForSimpleHashMapSize.class, TestForSimpleHashMapGet.class,
        TestForHashMapSize.class, TestForHashMapGet.class})
public class AllTest {

}
