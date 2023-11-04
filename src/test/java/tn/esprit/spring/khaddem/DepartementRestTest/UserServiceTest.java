//package tn.esprit.spring.khaddem.DepartementRestTest;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import tn.esprit.spring.khaddem.repositories.DepartementRepository;
//import tn.esprit.spring.khaddem.services.DepartementServiceImpl;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class UserServiceTest {
//
//    @Autowired
//    private DepartementRepository departementRepository;
//
//    @Autowired
//    private DepartementServiceImpl departementService;
//
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
//        User existingUser = new User(); // Create a user instance
//        existingUser.setUserName(existingUsername);
//        userRepository.save(existingUser); // Simulate user existing in the database
//
//        // Act
//        boolean result = userService.delete(existingUsername);
//
//        // Assert
//        assertTrue(result); // Expecting true because the user exists
//        assertTrue(existingUser.getRole().isEmpty()); // Ensure roles are cleared
//        assertNull(userRepository.findById(existingUsername).orElse(null)); // Ensure the user is deleted
//    }
//}
