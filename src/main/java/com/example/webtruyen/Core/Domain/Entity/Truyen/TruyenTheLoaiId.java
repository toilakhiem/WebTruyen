package com.example.webtruyen.Core.Domain.Entity.Truyen;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;
@EqualsAndHashCode
public class TruyenTheLoaiId implements Serializable {
    public Truyen truyen;
    public TheLoai theLoai;
    public TruyenTheLoaiId(Truyen truyen, TheLoai theLoai) {
        this.truyen = truyen;
        this.theLoai = theLoai;
    }
}
