package JUnit_Basic_Testing_Exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class mainjava {
	private static mainjava object;

	public static mainjava getinstance() {
		if (object == null) object = new mainjava();
		return object;
	}

	

	public int testaddition(int a, int b) {
		return a + b;
	}

	public Integer square(int input) {
		return input * input;
	}

	public boolean checkUserFormat(String name, String password) {
		String namePattern = "^[a-zA-Z0-9._]{3,20}$";
		String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$";
		return name.matches(namePattern) && password.matches(passwordPattern);
	}
}

public class Assertions_in_JUnit {

	private mainjava object;

	@BeforeEach
	public void getinstance() {
		object = mainjava.getinstance();
		System.out.println("Setup: Instance created");
	}

	@AfterEach
	public void destroyinstance() {
		object = null;
		System.out.println("Cleanup: Instance destroyed");
	}

	@Test
	public void addition() {
		int a = 5, b = 12;
		int result = object.testaddition(a, b);
		System.out.println("Testing addition: " + a + " + " + b + " = " + result);
		if (result == 17) {
			System.out.println("Assertion passed");
		} else {
			System.out.println("Assertion failed: Expected 17, got " + result);
		}
		assertEquals(17, result, "Addition failed");
	}

	@Test
	public void checknull() {
		mainjava obj = object.getinstance();
		System.out.println("Checking if instance is not null");
		if (obj != null) {
			System.out.println("Object is not null");
		} else {
			System.out.println("Object is null");
		}
		assertNotNull(obj);
	}

	@Test
	public void checkUser() {
		String name = "sainarasimhareddy";
		String password = "129213wjfA@";
		System.out.println("Checking user format manually: " + name + " / " + password);
		boolean valid = object.checkUserFormat(name, password);
		if (valid) {
			System.out.println("User format is valid");
		} else {
			System.out.println("User format is invalid");
		}
		assertTrue(valid);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	public void square(int input) {
		int expected = input * input;
		int result = object.square(input);
		System.out.println("Testing square: " + input + "^2 = " + result);
		if (expected == result) {
			System.out.println("Square passed for input " + input);
		} else {
			System.out.println("Square failed: Expected " + expected + ", got " + result);
		}
		assertEquals(expected, result);
	}

	@ParameterizedTest
	@CsvSource({
		"sainarasimhareddy, 1287321093A@j",
		"oinuwefzd, 127638176"  // This one should fail since password expects a capital and a small and also a special character
	})
	public void checkUserAuto(String name, String password) {
		System.out.println("Checking user auto format: " + name + " / " + password);
		boolean valid = object.checkUserFormat(name, password);
		if (valid) {
			System.out.println("Auto check passed");
		} else {
			System.out.println("Auto check failed");
		}
		assertTrue(valid);
	}
}
//output 
//Setup: Instance created
//Checking user auto format: sainarasimhareddy / 1287321093A@j
//Auto check passed
//Cleanup: Instance destroyed
//Setup: Instance created
//Checking user auto format: oinuwefzd / 127638176
//Auto check failed
//Cleanup: Instance destroyed
//Setup: Instance created
//Testing addition: 5 + 12 = 17
//Assertion passed
//Cleanup: Instance destroyed
//Setup: Instance created
//Testing square: 1^2 = 1
//Square passed for input 1
//Cleanup: Instance destroyed
//Setup: Instance created
//Testing square: 2^2 = 4
//Square passed for input 2
//Cleanup: Instance destroyed
//Setup: Instance created
//Testing square: 3^2 = 9
//Square passed for input 3
//Cleanup: Instance destroyed
//Setup: Instance created
//Testing square: 4^2 = 16
//Square passed for input 4
//Cleanup: Instance destroyed
//Setup: Instance created
//Testing square: 5^2 = 25
//Square passed for input 5
//Cleanup: Instance destroyed
//Setup: Instance created
//Checking user format manually: sainarasimhareddy / 129213wjfA@
//User format is valid
//Cleanup: Instance destroyed
//Setup: Instance created
//Checking if instance is not null
//Object is not null
//Cleanup: Instance destroyed

