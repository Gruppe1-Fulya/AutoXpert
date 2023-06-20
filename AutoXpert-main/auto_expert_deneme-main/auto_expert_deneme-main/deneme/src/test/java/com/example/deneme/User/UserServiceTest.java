//package com.example.deneme.User;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.when;
//
//public class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    public UserServiceTest() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetUserByUsername() {
//        // Test verilerini oluştur
//        String username = "john.doe";
//        User expectedUser = new User();
//        expectedUser.setUsername(username);
//
//        // UserRepository mock'una sahte bir kullanıcı dönmesi için yapılandırma yap
//        when(userRepository.findByUsername(username)).thenReturn(expectedUser);
//
//        // UserService üzerindeki getUserByUsername() yöntemini çağır
//        User actualUser = userService.getUserByUsername(username);
//
//        // Beklenen sonucu kontrol et
//        Assertions.assertEquals(expectedUser, actualUser);
//    }
//
//    @Test
//    public void testGetUserById() {
//        // Test verilerini oluştur
//        int userId = 1;
//        User expectedUser = new User();
//        expectedUser.setId((long) userId);
//
//        // UserRepository mock'una sahte bir kullanıcı dönmesi için yapılandırma yap
//        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(expectedUser));
//
//        // UserService üzerindeki getUserById() yöntemini çağır
//        User actualUser = userService.getUserById(userId);
//
//        // Beklenen sonucu kontrol et
//        Assertions.assertEquals(expectedUser, actualUser);
//    }
//}


