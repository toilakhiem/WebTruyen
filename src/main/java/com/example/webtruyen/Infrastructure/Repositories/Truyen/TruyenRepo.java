package com.example.webtruyen.Infrastructure.Repositories.Truyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TruyenRepo extends JpaRepository<Truyen, Long> {
    @Query("select t from Truyen t where t.TenTruyen = ?1")
    Truyen findByTen(String name);
    @Query("select t.Truyen from TheLoai t")
    Page<Truyen> getTruyenByTheLoai(String tenTheLoai, Pageable pageable);
}
