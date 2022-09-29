package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.example.webtruyen.Core.Domain.Common.StatusStory;
import com.example.webtruyen.Core.Domain.Entity.User.Accounts;
import com.example.webtruyen.Core.Domain.Entity.UserTruyen.UserTruyenDangDoc;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "Entity_Story")
public class Truyen {
    @Id
    public UUID id;
    public String TenTruyen;
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    public Accounts TacGia;
    public String AnhBia;
    public Long LuotXem;
    public StatusStory TrangThai;
    public float DanhGia;
    public String MotaNgan;
    //TheLoai
    @OneToMany(mappedBy = "truyen")
    public List<TruyenTheLoai> truyenTheLoai;
    //Chapter
    @OneToMany(mappedBy = "truyen")
    public List<Chapter> chapterList;
    //NguoiDangDoc
    @OneToMany(mappedBy = "truyen")
    public List<UserTruyenDangDoc> NguoiDocTruyen;

}
