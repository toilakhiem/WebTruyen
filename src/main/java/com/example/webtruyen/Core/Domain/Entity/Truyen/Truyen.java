package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.example.webtruyen.Core.Domain.Common.StatusStory;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
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
    private Long id;
    private String tenTruyen;
    @ManyToOne
    private User tacGia;
    private String anhBia;
    private Long luotXem = 0L;
    private StatusStory trangThai;
    private float danhGia;
    @Column(columnDefinition = "TEXT")
    private String motaNgan;
    private LocalDateTime ngayDang;
    private LocalDateTime lastUpdate;
    @OneToMany(mappedBy = "truyen") @JsonBackReference
    private List<Chapter> chapterList;
    @ManyToMany(mappedBy = "truyenDangDoc") @JsonBackReference
    private Collection<User> nguoiDangDoc;
    @ManyToMany(mappedBy = "truyens") @JsonBackReference
    private Collection<TheLoai> theLoais = new ArrayList<TheLoai>();
    public Truyen(String tenTruyen, String motaNgan) {
        this.tenTruyen = tenTruyen;
        this.motaNgan = motaNgan;
    }
}
