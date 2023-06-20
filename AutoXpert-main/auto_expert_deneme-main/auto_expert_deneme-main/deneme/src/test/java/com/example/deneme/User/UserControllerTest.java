//package com.example.deneme.User;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//class UserControllerTest {
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private UserController userController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testUserLogin_Successful() {
//        // Arrange
//        String username = "testuser";
//        String password = "testpassword";
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//
//        when(userService.getUserByUsername(username)).thenReturn(user);
//        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(true);
//
//        // Act
//        ResponseEntity<String> response = userController.userLogin(username, password);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("User login successful", response.getBody());
//        verify(userService, times(1)).getUserByUsername(username);
//        verify(passwordEncoder, times(1)).matches(password, user.getPassword());
//    }
//
//    @Test
//    void testUserLogin_InvalidCredentials() {
//        // Arrange
//        String username = "testuser";
//        String password = "testpassword";
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode("wrongpassword"));
//
//        when(userService.getUserByUsername(username)).thenReturn(user);
//        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(false);
//
//        // Act
//        ResponseEntity<String> response = userController.userLogin(username, password);
//
//        // Assert
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//        assertEquals("Invalid username or password", response.getBody());
//        verify(userService, times(1)).getUserByUsername(username);
//        verify(passwordEncoder, times(1)).matches(password, user.getPassword());
//    }
//
//    @Test
//    void testUserLogin_UserNotFound() {
//        // Arrange
//        String username = "nonexistentuser";
//        String password = "testpassword";
//
//        when(userService.getUserByUsername(username)).thenReturn(null);
//
//        // Act
//        ResponseEntity<String> response = userController.userLogin(username, password);
//
//        // Assert
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//        assertEquals("Invalid username or password", response.getBody());
//        verify(userService, times(1)).getUserByUsername(username);
//        verify(passwordEncoder, never()).matches(anyString(), anyString());
//    }
//
//    @SpringBootTest
//    @AutoConfigureMockMvc
//    public class UserControllerTests {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @Test
//        public void testUserLogin() throws Exception {
//            mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
//                            .param("username", "testuser")
//                            .param("password", "testpassword")
//                            .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().string("User login successful"));
//        }
//    }
//
//}


