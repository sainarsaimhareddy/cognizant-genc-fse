import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserRepository {
    User findById(int id);
}

class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getUserName(int id) {
        System.out.println("Fetching user with ID: " + id);
        User user = repository.findById(id);
        if (user != null) {
            System.out.println("User found: " + user.getName());
            return user.getName();
        }
        System.out.println("User not found.");
        return "User not found";
    }
}

public class Verifying_Interactions {

    @Test
    void testGetUserName() {
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.findById(1)).thenReturn(new User(1, "Narasimha"));

        UserService service = new UserService(mockRepository);

        String result = service.getUserName(1);
        System.out.println("Result from service: " + result);
        assertEquals("Narasimha", result);

        verify(mockRepository).findById(1);
        System.out.println("Verified that findById(1) was called.");
    }
}
/*Fetching user with ID: 1
User found: Narasimha
Result from service: Narasimha
Verified that findById(1) was called.
*/