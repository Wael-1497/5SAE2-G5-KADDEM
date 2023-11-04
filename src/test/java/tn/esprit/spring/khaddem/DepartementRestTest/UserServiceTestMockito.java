//package tn.esprit.spring.khaddem.DepartementRestTest;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import tn.esprit.spring.entities.User;
//import tn.esprit.spring.repositories.UserRepository;
//import tn.esprit.spring.services.User.UserService;
//
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//
//public class UserServiceTestMockito {
//
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this); // Initialize mocks
//
//        // Define mock behaviors
//        reset(userRepository);
//
//        when(userRepository.save(any(User.class))).thenReturn(new User());
//        when(userRepository.existsById("test")).thenReturn(true);
//        when(userRepository.existsById("syrine")).thenReturn(false);
//    }
////
//    @Test
//    public void testDeleteUserWhenUsernameDoesNotExist() {
//        // Arrange
//        String nonExistentUsername = "syrine";
//
//        // Act
//        boolean result = userService.delete(nonExistentUsername);
//
//        // Assert
//        assertFalse(result); // Expecting false because the user doesn't exist
//    }
//
//    @Test
//    public void testDeleteUserWhenUsernameExists() {
//        // Arrange
//        String existingUsername = "test";
//
//        // Act
//        boolean result = userService.delete(existingUsername);
//        System.out.println("Result: " + result); // Add this line to log the result
//
//        // Assert
//        assertTrue(result);
//        verify(userRepository).existsById(existingUsername);
//        verify(userRepository).delete(any(User.class));
//    }
//}
