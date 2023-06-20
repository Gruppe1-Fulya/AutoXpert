//package com.example.deneme.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> userLogin(@RequestParam("username") String username,
//                                            @RequestParam("password") String password) {
//        User user = userService.getUserByUsername(username);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            // Kullanıcı girişi başarılı
//            return ResponseEntity.ok("User login successful");
//        } else {
//            // Kullanıcı adı veya şifre hatalı
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//    }
//
//
///*
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody User user) {
//        // Yeni kullanıcı kaydı işlemleri burada gerçekleştirilir
//        // Şifreyi şifreleme işlemi yapılır ve kullanıcıyı veritabanına kaydedebilirsiniz
//
//        // Örnek kaydetme işlemi
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userService.saveUser(user);
//
//        return ResponseEntity.ok("User registered successfully");
//    }
//
// */
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//}



