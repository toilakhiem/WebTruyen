package com.example.webtruyen.Infrastructure.Repositories;

import com.example.webtruyen.Core.Domain.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    @Query(value = "select * from User u where u.UserName = ?1", nativeQuery = true)
    User findByUsername(String userName);
}
