package com.example.webtruyen.Core.Domain.Entity.Truyen;

import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@EqualsAndHashCode
public class ChapterId implements Serializable {
    public String TenChuong;
    public int ChuongSo;
    public ChapterId(String TenChuong, int ChuongSo){
        this.TenChuong = TenChuong;
        this.ChuongSo = ChuongSo;
    }

}
