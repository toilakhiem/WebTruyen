package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.example.webtruyen.Core.Domain.Common.StatusStory;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
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
    public String TenTruyen;
    @ManyToOne
    public User TacGia;
    public String AnhBia;
    public Long LuotXem;
    public StatusStory TrangThai;
    public float DanhGia;
    @Column(columnDefinition = "TEXT")
    public String MotaNgan;
    public LocalDateTime NgayDang;
    public LocalDateTime LastUpdate;
    @OneToMany(mappedBy = "truyen")
    public List<Chapter> chapterList;

}
