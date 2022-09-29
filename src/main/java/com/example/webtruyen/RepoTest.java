package com.example.webtruyen;

import com.example.webtruyen.Core.Domain.Entity.User.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepoTest extends JpaRepository<Accounts, UUID> {
}
