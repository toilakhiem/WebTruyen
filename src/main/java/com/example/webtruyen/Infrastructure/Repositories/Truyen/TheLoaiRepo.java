package com.example.webtruyen.Infrastructure.Repositories.Truyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheLoaiRepo extends JpaRepository<TheLoai, Long> {
    @Query("select u from TheLoai u where u.tenTheLoai = ?1")
    TheLoai findByTenTheLoai(String tenTheLoai);
}
