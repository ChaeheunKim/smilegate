package org.example.smilegate.config.auth;


import lombok.RequiredArgsConstructor;
import org.example.smilegate.user.domain.User;
import org.example.smilegate.user.domain.UserRole;
import org.example.smilegate.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        String adminUsername = "admin";
        String adminEmail = "admin@example.com";
        String rawPassword = "admin1234!";

        if (!userRepository.existsByUsername(adminUsername)) {
            User admin = new User();
            admin.setUsername(adminUsername);
            admin.setPassword(rawPassword);
            admin.setRole(UserRole.ADMIN);
            admin.setEmail(adminEmail);
            userRepository.save(admin);
            System.out.println("기본 ADMIN 계정 생성 완료");
        }
    }
}
