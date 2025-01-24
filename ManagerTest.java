package User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    @Test
    public void testManagerConstructorAndGetters() {

        String expectedId = "M123";
        String expectedPassword = "password123";


        Manager manager = new Manager(expectedId, expectedPassword);


        assertEquals(expectedId, manager.getManagerId(), "Manager ID should match the constructor input");
        assertEquals(expectedPassword, manager.getManagerPassword(), "Manager Password should match the constructor input");
    }

    @Test
    public void testSetManagerId() {

        Manager manager = new Manager("M123", "password123");
        String newId = "M456";


        manager.setManagerId(newId);

        assertEquals(newId, manager.getManagerId(), "Manager ID should update correctly");
    }

    @Test
    public void testSetManagerPassword() {

        Manager manager = new Manager("M123", "password123");
        String newPassword = "newPassword123";


        manager.setManagerPassword(newPassword);


        assertEquals(newPassword, manager.getManagerPassword(), "Manager Password should update correctly");
    }
}
