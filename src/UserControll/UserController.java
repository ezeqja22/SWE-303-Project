package UserControll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import User.User;
import User.Manager;

public class UserController {

	private ArrayList<User> users;
	private ArrayList<Manager> managers;
	private File file;

	public UserController() {
		users = new ArrayList<>();
		file = new File("users.bin");
		if (file.exists()) {
			readUsers();
		}
	}

	@SuppressWarnings("unchecked")
	private void readUsers() {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (ArrayList<User>) ois.readObject();
			fis.close();
			ois.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void writeUsers() {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void addUser(User u) {
		this.users.add(u);
	}

	public boolean signUp(String firstName, String lastName, String email, String password, String verifyPassword,
			String gendre, boolean isRemeberMe) {

		if (password.equals(verifyPassword)) {
			User u = new User(firstName, lastName, email, password, gendre, isRemeberMe);
			this.addUser(u);
			writeUsers();
			return true;
		}

		return false;
	}

	public void print() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
	}

	public User login(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public Manager manlogin(String ManagerId, String ManagerPassword) {
		for (Manager manager : managers) {
			if (manager.getManagerId().equals(ManagerId) && manager.getManagerPassword().equals(ManagerPassword)) {
				return manager;
			}
		}
		return null;
	}

}
