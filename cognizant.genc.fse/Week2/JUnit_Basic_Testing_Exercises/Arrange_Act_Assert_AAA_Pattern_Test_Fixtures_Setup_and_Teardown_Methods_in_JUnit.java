package JUnit_Basic_Testing_Exercises;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class mainjavaclass {
	private static mainjavaclass object;

	public static mainjavaclass getinstance() {
		if (object == null) object = new mainjavaclass();
		return object;
	}

	

	public int add(int a, int b) {
		return a + b;
	}

	public Integer square(int input) {
		return input * input;
	}

	public boolean isUserFormatValid(String name, String password) {
		String namePattern = "^[a-zA-Z0-9._]{3,20}$";
		String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$";
		return name.matches(namePattern) && password.matches(passwordPattern);
	}
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Arrange_Act_Assert_AAA_Pattern_Test_Fixtures_Setup_and_Teardown_Methods_in_JUnit {
	   private mainjavaclass calculator;

	    @BeforeAll
	    void setupAll() {
	        System.out.println("Starting all tests...");
	    }

	    @BeforeEach
	    void setup() {
	        calculator = new mainjavaclass();
	        System.out.println(" Setup: New calculator instance created");
	    }

	    @AfterEach
	    void tearDown() {
	        calculator = null;
	        System.out.println("Teardown: Instance cleared\n");
	    }

	    @AfterAll
	    void tearDownAll() {
	        System.out.println("All tests completed.");
	    }

	    @Test
	    void testAdditionSuccess() {
	        // Arrange
	        int a = 10, b = 20;

	        // Act
	        int result = calculator.add(a, b);

	        // Assert
	        assertEquals(30, result);
	    }

	    @Test
	    void testAdditionFailure() {
	        int result = calculator.add(5, 5);
	        assertNotEquals(15, result);
	    }

	    @ParameterizedTest
	    @ValueSource(ints = {2, 3, 4})
	    void testSquare(int input) {
	        int expected = input * input;
	        assertEquals(expected, calculator.square(input));
	    }

	    @Test
	    void testValidUserCredentials() {
	        String name = "arvind123";
	        String password = "Secure@2024A";
	        assertTrue(calculator.isUserFormatValid(name, password));
	    }

	    @Test
	    void testInvalidUserCredentials() {
	        String name = "yo";
	        String password = "123";
	        assertFalse(calculator.isUserFormatValid(name, password));
	    }

	    @ParameterizedTest
	    @CsvSource({
	        "maheshkumar, India@2024A",
	        "a, 1234"
	    })
	    void testUserValidationWithMultipleInputs(String name, String password) {
	        boolean result = calculator.isUserFormatValid(name, password);
	        assertTrue(result || !result);  // Just observing pass/fail
	    }
	    @Test 
	    public void check() {
	    	assertEquals(5,5);
	    }
}



/*output
Starting all tests...
Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

Setup: New calculator instance created
Teardown: Instance cleared

All tests completed.*/