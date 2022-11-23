package com.example.webtruyen.Infrastructure.Repositories.Truyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AuthorRepo extends JpaRepository<Author, UUID> {
    @Query("select u from Author u where u.userName = ?1")
    Author findByUserName(String name);
}
