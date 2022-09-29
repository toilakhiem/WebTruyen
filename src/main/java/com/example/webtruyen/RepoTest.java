package com.example.webtruyen;

import com.example.webtruyen.Core.Domain.Entity.User.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepoTest extends JpaRepository<Account, UUID> {
}
