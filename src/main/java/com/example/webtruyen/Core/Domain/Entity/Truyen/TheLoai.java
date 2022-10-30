package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.example.webtruyen.Core.Domain.Common.TenTheLoai;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Category")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long uuid;
    public TenTheLoai tenTheLoai;
    public String MoTaNgan;
    @OneToMany(mappedBy = "theLoai")
    public List<TruyenTheLoai> truyenTheLoai;
}
