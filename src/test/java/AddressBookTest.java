import com.AddressBook;
import com.BuddyInfo;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeremydunsmore on 1/12/2017.
 */
public class AddressBookTest {
    private AddressBook book;

    @Before
    public void setup(){
        this.book = new AddressBook();
    }

    @Test
    public void addBuddy() throws Exception {
        BuddyInfo buddy = new BuddyInfo("Matt","123-456-7890");
        book.addBuddy(buddy);
        assertEquals(1,book.getBuddies().size());
    }

    @Test
    public void displayBuddies() throws Exception {
        BuddyInfo buddy = new BuddyInfo("Matt","123-456-7890");
        book.addBuddy(buddy);
        assertEquals("Matt, 123-456-7890, \n", book.displayBuddies());
    }

    @Test
    public void testRemove(){
        BuddyInfo buddy = new BuddyInfo("Matt","123-456-7890");
        book.addBuddy(buddy);
        book.removeBuddy(buddy);
        assertEquals(0,book.getBuddies().size());
    }

}