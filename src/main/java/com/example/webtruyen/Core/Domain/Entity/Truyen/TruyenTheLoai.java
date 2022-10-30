package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.example.webtruyen.Core.Domain.Key.TruyenTheLoaiKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Story_Category")
@NoArgsConstructor
public class TruyenTheLoai implements Serializable {
    @EmbeddedId
    private TruyenTheLoaiKey truyenTheLoaiKey;
    @ManyToOne @MapsId("truyenId")
    public Truyen truyen;
    @ManyToOne @MapsId("theLoaiId")
    public TheLoai theLoai;

}
