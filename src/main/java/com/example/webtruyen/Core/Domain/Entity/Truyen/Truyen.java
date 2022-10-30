package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.example.webtruyen.Core.Domain.Common.StatusStory;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "Story")
@NoArgsConstructor
@AllArgsConstructor
public class Truyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String Ten;
    @ManyToOne
    public User TacGia;
    public String AnhBia;
    public Long LuotXem;
    public StatusStory TrangThai;
    public float DanhGia;
    @Column(columnDefinition = "TEXT")
    public String MotaNgan;
    //TheLoai
    @OneToMany(mappedBy = "truyen")
    public List<TruyenTheLoai> truyenTheLoai;
    //Chapter
    @OneToMany(mappedBy = "truyen")
    public List<Chapter> chapterList;

    public Truyen(String tenTruyen, User tacGia, String anhBia, Long luotXem, StatusStory trangThai, float danhGia, String motaNgan, List<TruyenTheLoai> truyenTheLoai, List<Chapter> chapterList) {
        Ten = tenTruyen;
        TacGia = tacGia;
        AnhBia = anhBia;
        LuotXem = luotXem;
        TrangThai = trangThai;
        DanhGia = danhGia;
        MotaNgan = motaNgan;
        this.truyenTheLoai = truyenTheLoai;
        this.chapterList = chapterList;
    }
}
