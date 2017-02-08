package armstrong.alexandra;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class PhoneBookTest{

    PhoneBook phoneBook;
    String[] numbers;

    @Before
    public void setUp(){
        phoneBook = new PhoneBook();
        String[] numbers = {"Number"};
        String[] numbers2 = {"Number2"};
        phoneBook.add("Name", numbers);
        phoneBook.add("Name2", numbers2);
    }

    @Test
    public void lookUpTest(){
        try {
            String[] expected = {"Number"};
            String[] actual = phoneBook.lookUp("Name");
            assertArrayEquals(expected, actual);
        } catch (RecordNotPresent e) {
            System.out.println("Record not present");
        }
    }

    @Test
    public void addTest(){
        phoneBook.add("Name3", numbers);
        int expected = 3;
        int actual = phoneBook.size();
        assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        phoneBook.remove("Name2");
        int expected = 1;
        int actual = phoneBook.size();
        assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest(){
        try {
            String[] number = {"Number"};
            String expected = "Name";
            String actual = phoneBook.reverseLookUp(number);
            assertEquals(expected, actual);
        } catch (RecordNotPresent e) {
            System.out.println("Record not present");
        }
    }
}