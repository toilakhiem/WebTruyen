package com.example.webtruyen.Core.Domain.Entity.Truyen;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Chapter")
@NoArgsConstructor
public class Chapter implements Serializable {
    public String TenChuong;
    @Id
    public int ChuongSo;
    @Column(columnDefinition = "LONGTEXT")
    public String NoiDungChuong;
    @ManyToOne
    @JoinColumn(name = "truyen_id")
    public Truyen truyen;
}
