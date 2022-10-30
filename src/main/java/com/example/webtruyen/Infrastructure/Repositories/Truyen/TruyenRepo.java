package com.example.webtruyen.Infrastructure.Repositories.Truyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TruyenRepo extends JpaRepository<Truyen,Long> {
    @Query("select t from Truyen t where t.Ten = ?1")
    Truyen findByTen(String name);
}
