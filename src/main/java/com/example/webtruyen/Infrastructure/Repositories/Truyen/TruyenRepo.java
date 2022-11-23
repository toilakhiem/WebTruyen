package com.example.webtruyen.Infrastructure.Repositories.Truyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TruyenRepo extends JpaRepository<Truyen, Long> {
    @Query("select t from Truyen t where t.tenTruyen = ?1")
    Truyen findByTen(String name);
    @Query(value = "select t from Truyen t join t.theLoais tl where tl.tenTheLoai = ?1")
    List<Truyen> getTruyenByTheLoai(String tenTheLoai, Pageable pageable);

    @Query("select t from Truyen t order by t.ngayDang desc ")
    List<Truyen> getTruyenMoiNhat(Pageable pageable);

    @Query("select t from Truyen t order by t.lastUpdate desc ")
    List<Truyen> getTruyenMoiCapNhat(Pageable pageable);
    @Query(value = "SELECT max(chuong_so) FROM webtruyenjava.chapter where truyen_id = ?1", nativeQuery = true)
    int chuongMoiNhat(String truyenId);
}
