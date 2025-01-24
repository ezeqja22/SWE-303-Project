package User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserConstructorAndGetters() {
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        String password = "password123";
        String gendre = "Male";
        boolean isRememberMe = true;

        User user = new User(firstName, lastName, email, password, gendre, isRememberMe);

        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(gendre, user.getGenre());
        assertTrue(user.isRemeberMe());
    }

    @Test
    public void testSetFirstName() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        String newFirstName = "Jane";

        user.setFirstName(newFirstName);

        assertEquals(newFirstName, user.getFirstName());
    }

    @Test
    public void testSetLastName() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        String newLastName = "Smith";

        user.setLastName(newLastName);

        assertEquals(newLastName, user.getLastName());
    }

    @Test
    public void testSetEmail() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        String newEmail = "janedoe@example.com";

        user.setEmail(newEmail);

        assertEquals(newEmail, user.getEmail());
    }

    @Test
    public void testSetPassword() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        String newPassword = "newpassword456";

        user.setPassword(newPassword);

        assertEquals(newPassword, user.getPassword());
    }

    @Test
    public void testSetGenre() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        String newGenre = "Female";

        user.setGenre(newGenre);

        assertEquals(newGenre, user.getGenre());
    }

    @Test
    public void testSetDescription() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        String newDescription = "This is a test description";

        user.setDescripton(newDescription);

        assertEquals(newDescription, user.getDescripton());
    }

    @Test
    public void testSetProfession() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        String newProfession = "Software Engineer";

        user.setProfession(newProfession);

        assertEquals(newProfession, user.getProfession());
    }

    @Test
    public void testSetRememberMe() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);

        user.setRemeberMe(false);

        assertFalse(user.isRemeberMe());
    }

    @Test
    public void testToString() {
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "Male", true);
        user.setDescripton("A description");
        user.setProfession("Software Engineer");

        String expectedString = "User [firstName=John, lastName=Doe, email=johndoe@example.com, password=password123, " +
                "genre=Male, descripton=A description, profession=Software Engineer, isRemeberMe=true]";

        String actualString = user.toString();

        assertEquals(expectedString, actualString);
    }
}
