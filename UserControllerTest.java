package UserControll;

import User.User;
import User.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

	private UserController userController;

	@BeforeEach
	void setUp() {
		userController = new UserController();
	}

	@Test
	void testSignUpSuccess() {
		boolean result = userController.signUp(
				"Alice", "Wonder", "alice.wonder@example.com",
				"password123", "password123", "Female", true
		);
		assertTrue(result, "User sign-up should succeed when passwords match");
	}

	@Test
	void testSignUpFailureDueToPasswordMismatch() {
		boolean result = userController.signUp(
				"Bob", "Builder", "bob.builder@example.com",
				"password123", "wrongPassword", "Male", false
		);
		assertFalse(result, "User sign-up should fail when passwords do not match");
	}

	@Test
	void testLoginSuccess() {
		userController.signUp(
				"Alice", "Wonder", "alice.wonder@example.com",
				"password123", "password123", "Female", true
		);
		User user = userController.login("alice.wonder@example.com", "password123");
		assertNotNull(user, "Login should succeed with correct email and password");
		assertEquals("Alice", user.getFirstName(), "User's first name should match");
	}

	@Test
	void testLoginFailure() {
		userController.signUp(
				"Alice", "Wonder", "alice.wonder@example.com",
				"password123", "password123", "Female", true
		);
		User user = userController.login("alice.wonder@example.com", "wrongPassword");
		assertNull(user, "Login should fail with incorrect password");
	}

	@Test
	void testManagerLoginSuccess() {
		Manager manager = new Manager("managerId", "managerPassword");
		userController.setManagers(new ArrayList<>()); // Add a setManagers method in UserController
		userController.getManagers().add(manager);

		Manager result = userController.manlogin("managerId", "managerPassword");
		assertNotNull(result, "Manager login should succeed with correct credentials");
	}

	@Test
	void testManagerLoginFailure() {
		Manager manager = new Manager("managerId", "managerPassword");
		userController.setManagers(new ArrayList<>()); // Add a setManagers method in UserController
		userController.getManagers().add(manager);

		Manager result = userController.manlogin("wrongId", "wrongPassword");
		assertNull(result, "Manager login should fail with incorrect credentials");
	}
}
