package com.pruebatecnica.prueba_tecnica.config;

import com.pruebatecnica.prueba_tecnica.entity.Users;
import com.pruebatecnica.prueba_tecnica.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.annotation.PostConstruct;
import java.util.Set;

@Configuration
public class DataLoader {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public DataLoader(UserRepository repo,
                      PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostConstruct
    public void loadUsers() {

        if (repo.count() == 0) {

            Users admin = new Users();
            admin.setUserName("admin");
            admin.setUserPassword(
                encoder.encode("admin123")
            );
            admin.setRoles(Set.of("ROLE_ADMIN"));

            Users user = new Users();
            user.setUserName("user");
            user.setUserPassword(
                encoder.encode("user123")
            );
            user.setRoles(Set.of("ROLE_USER"));

            repo.save(admin);
            repo.save(user);
        }
    }
}
