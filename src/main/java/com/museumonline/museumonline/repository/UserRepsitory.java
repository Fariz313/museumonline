package com.museumonline.museumonline.repository;
import com.museumonline.museumonline.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepsitory extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}