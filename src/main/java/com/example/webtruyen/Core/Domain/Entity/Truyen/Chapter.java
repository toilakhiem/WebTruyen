package com.example.webtruyen.Core.Domain.Entity.Truyen;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Entity_Chapter")
public class Chapter implements Serializable {
    @Id
    public String TenChuong;
    @Id
    public int ChuongSo;
    public String NoiDungChuong;
    @ManyToOne
    @JoinColumn(name = "truyen_id")
    public Truyen truyen;
}
