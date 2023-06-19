package com.example.deneme.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class UserRepositoryTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserRepositoryTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByUsername() {
        // Test verilerini oluştur
        String username = "john.doe";
        User expectedUser = new User();
        expectedUser.setUsername(username);

        // UserRepository mock'una sahte bir kullanıcı dönmesi için yapılandırma yap
        when(userRepository.findByUsername(username)).thenReturn(expectedUser);

        // UserRepository üzerindeki findByUsername() yöntemini çağır
        User actualUser = userRepository.findByUsername(username);

        // Beklenen sonucu kontrol et
        Assertions.assertEquals(expectedUser, actualUser);
    }
}

