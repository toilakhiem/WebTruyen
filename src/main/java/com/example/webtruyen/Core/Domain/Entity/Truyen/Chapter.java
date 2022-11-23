package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Chapter")
@NoArgsConstructor
@Getter
@Setter
public class Chapter implements Serializable {
    private String tenChuong;
    @Id
    private int chuongSo;
    @Column(columnDefinition = "LONGTEXT")
    private String noiDungChuong;
    @ManyToOne
    @JoinColumn(name = "truyen_id")
    @JsonBackReference
    private Truyen truyen;

    public Chapter(String tenChuong, int chuongSo, String noiDungChuong, Truyen truyen) {
        this.tenChuong = tenChuong;
        this.chuongSo = chuongSo;
        this.noiDungChuong = noiDungChuong;
        this.truyen = truyen;
    }
}
