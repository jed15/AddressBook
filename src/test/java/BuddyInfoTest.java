import com.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jeremydunsmore on 1/12/2017.
 */
public class BuddyInfoTest {
    private BuddyInfo buddy;
    @Before
    public void setup(){
        buddy = new BuddyInfo("Matt", "123-456-7890");
    }


    @Test
    public void testToString() throws Exception {
        assertEquals("Matt, 123-456-7890",buddy.toString());
    }

}