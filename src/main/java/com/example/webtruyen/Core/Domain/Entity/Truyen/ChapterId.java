package com.example.webtruyen.Core.Domain.Entity.Truyen;

import javax.persistence.Id;
import java.io.Serializable;

public class ChapterId implements Serializable {
    public String TenChuong;
    public int ChuongSo;
    public ChapterId(String TenChuong, int ChuongSo){
        this.TenChuong = TenChuong;
        this.ChuongSo = ChuongSo;
    }

}
